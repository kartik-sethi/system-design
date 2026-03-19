package io.github.kartiksethi;

import io.github.kartiksethi.billing.Bill;
import io.github.kartiksethi.enums.PaymentMode;
import io.github.kartiksethi.payment.Payment;
import io.github.kartiksethi.reservations.Reservation;
import io.github.kartiksethi.vehicle.Vehicle;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Car Rental System Demo...");
        testRentalSystemFlow();
        testConcurrency();
    }

    public static void testRentalSystemFlow() {
        // Initialize the central system
        VehicleRentalSystem rentalSystem = new VehicleRentalSystem();

        System.out.println("\n--- 1. Registering Users ---");
        User alice = new User(101, "Alice Smith", "DL-ALICE-123");
        User bob = new User(102, "Bob Jones", "DL-BOB-456");
        rentalSystem.addUser(alice);
        rentalSystem.addUser(bob);
        System.out.println("Registered User: " + alice.getName());
        System.out.println("Registered User: " + bob.getName());

        System.out.println("\n--- 2. Setting up Stores and Locations ---");
        Location downtownLoc = new Location(1, "100 Downtown Ave", "Metropolis", "ST", "12345");
        Location airportLoc = new Location(2, "500 Airport Rd", "Metropolis", "ST", "12345");
        
        Store downtownStore = new Store(1, "Downtown Auto Rentals", downtownLoc);
        Store airportStore = new Store(2, "Airport Express Rentals", airportLoc);
        
        // Add some vehicles to the stores
        Vehicle v1 = downtownStore.addVehicle("STATE-14-1111");
        Vehicle v2 = downtownStore.addVehicle("STATE-14-2222");
        Vehicle v3 = airportStore.addVehicle("STATE-10-3333");
        
        rentalSystem.addStore(downtownStore);
        rentalSystem.addStore(airportStore);
        System.out.println("Added Store: " + downtownStore.getName() + " with Vehicles: " + v1.getNumber() + ", " + v2.getNumber());
        System.out.println("Added Store: " + airportStore.getName() + " with Vehicle: " + v3.getNumber());

        System.out.println("\n--- 3. User Searching for a Store by Location ---");
        List<Store> availableStores = rentalSystem.getStores(downtownLoc.getId());
        System.out.println("Stores found at location " + downtownLoc.getCity() + " (ID: " + downtownLoc.getId() + "):");
        for (Store s : availableStores) {
            System.out.println(" - " + s.getName());
        }

        Store selectedStore = availableStores.get(0);

        System.out.println("\n--- 4. User Booking a Vehicle ---");
        Calendar cal = Calendar.getInstance();
        Date fromDate = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 5); // Book for 5 days
        Date toDate = cal.getTime();
        
        System.out.println("Alice is booking vehicle " + v1.getNumber() + " from " + selectedStore.getName());
        Reservation reservation = rentalSystem.reserveVehicle(selectedStore.getId(), alice.getId(), v1.getId(), fromDate, toDate);
        System.out.println("Reservation successful! ID: " + reservation.getId() + " for User ID: " + reservation.getUserId());

        System.out.println("\n--- 5. Generating the Bill ---");
        Bill bill = rentalSystem.generateBill(selectedStore.getId(), reservation.getId());
        System.out.println("Bill generated for Reservation ID: " + reservation.getId());
        System.out.println("Total Amount Due: $" + bill.getAmount() + " (Bill ID: " + bill.getId() + ")");

        System.out.println("\n--- 6. Processing Payment ---");
        System.out.println("Alice is paying via CARD...");
        Payment payment = rentalSystem.makePayment(selectedStore.getId(), bill, bill.getAmount(), PaymentMode.CARD);
        System.out.println("Payment Receipt -> ID: " + payment.getId() + " | Amount: $" + payment.getAmount() + " | Method: " + payment.getPaymentMode());

        System.out.println("\n--- 7. End of Trip (or Cancellation) ---");
        System.out.println("Bob tries to book the same vehicle, but it's reserved...");
        try {
            rentalSystem.reserveVehicle(selectedStore.getId(), bob.getId(), v1.getId(), fromDate, toDate);
        } catch (Exception e) {
            System.out.println("Failed to book: " + e.getMessage());
        }

        System.out.println("Alice returns the vehicle and finishes the reservation.");
        Reservation completedReservation = rentalSystem.cancelReservation(selectedStore.getId(), reservation.getId());
        System.out.println("Reservation " + completedReservation.getId() + " status is now: " + completedReservation.getReservationStatus());
    }

    public static void testConcurrency() {
        System.out.println("\n\n=== MULTITHREADING CONCURRENCY TEST ===");
        
        VehicleRentalSystem system = new VehicleRentalSystem();
        Location loc = new Location(1, "Test St", "Test City", "TS", "00000");
        Store store = new Store(10, "Test Store", loc);
        system.addStore(store);
        
        Vehicle v1 = store.addVehicle("TEST-01");
        System.out.println("Added Vehicle for testing concurrency: " + v1.getNumber() + " (ID: " + v1.getId() + ")");

        int threadCount = 5;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(1); // To make all threads start at once

        Calendar cal = Calendar.getInstance();
        Date from = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date to = cal.getTime();

        for (int i = 1; i <= threadCount; i++) {
            final int userId = i;
            executor.submit(() -> {
                try {
                    latch.await(); // Wait until latch is counted down to 0
                    System.out.println("Thread " + userId + " attempting to reserve vehicle " + v1.getId() + "...");
                    system.reserveVehicle(store.getId(), userId, v1.getId(), from, to);
                    System.out.println("Thread " + userId + " SUCCESSFULLY reserved vehicle " + v1.getId() + "!");
                } catch (Exception e) {
                    System.out.println("Thread " + userId + " FAILED to reserve: " + e.getMessage());
                }
            });
        }

        System.out.println("Releasing threads to start simultaneous reservation attempts...");
        latch.countDown(); // Let all threads go!

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("=== END CONCURRENCY TEST ===");
    }
}
