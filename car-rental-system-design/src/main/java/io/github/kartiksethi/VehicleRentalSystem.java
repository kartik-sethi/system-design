package io.github.kartiksethi;

import io.github.kartiksethi.billing.Bill;
import io.github.kartiksethi.enums.PaymentMode;
import io.github.kartiksethi.payment.Payment;
import io.github.kartiksethi.reservations.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleRentalSystem {

    List<Store> stores = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores = stores;
        this.users = users;
    }

    public VehicleRentalSystem(){}

    public void addUser(User user) {
        users.add(user);
    }
    public void addStore(Store store) {
        stores.add(store);
    }

    public List<Store> getStores(int locationId) {
        return stores.stream().filter(store -> store.getLocation().getId() == locationId).toList();
    }

    public Store getStoreById(int storeId) {
        return stores.stream().filter(store -> store.getId() == storeId).findFirst().orElseThrow(() -> new RuntimeException("Store not found"));
    }

    public Reservation reserveVehicle(int storeId, int userId, int vehicleId, Date from, Date to) {
        try {
            System.out.println("[VehicleRentalSystem] Attempting to reserve vehicle " + vehicleId + " for user " + userId + " at store " + storeId);
            Store store = getStoreById(storeId);
            Reservation reservation = store.reserveVehicle(userId, vehicleId, from, to);
            System.out.println("[VehicleRentalSystem] Reservation successful! Reservation ID: " + reservation.getId());
            return reservation;
        } catch (Exception e) {
            System.out.println("[VehicleRentalSystem] Failed to reserve vehicle: " + e.getMessage());
            throw e;
        }
    }

    public Bill generateBill(int storeId, int reservationId) {
        try {
            System.out.println("[VehicleRentalSystem] Generating bill for reservation " + reservationId + " at store " + storeId);
            Store store = getStoreById(storeId);
            Bill bill = store.generateBill(reservationId);
            System.out.println("[VehicleRentalSystem] Bill generated successfully! Bill ID: " + bill.getId());
            return bill;
        } catch (Exception e) {
            System.out.println("[VehicleRentalSystem] Failed to generate bill: " + e.getMessage());
            throw e;
        }
    }

    public Payment makePayment(int storeId, Bill bill, double amount, PaymentMode paymentMode) {
        try {
            System.out.println("[VehicleRentalSystem] Processing payment of $" + amount + " for bill " + bill.getId() + " at store " + storeId);
            Store store = getStoreById(storeId);
            Payment payment = store.makePayment(bill, amount, paymentMode);
            System.out.println("[VehicleRentalSystem] Payment processed successfully! Payment ID: " + payment.getId());
            return payment;
        } catch (Exception e) {
            System.out.println("[VehicleRentalSystem] Failed to process payment: " + e.getMessage());
            throw e;
        }
    }

    public Reservation cancelReservation(int storeId, int reservationId) {
        try {
            System.out.println("[VehicleRentalSystem] Attempting to cancel reservation " + reservationId + " at store " + storeId);
            Store store = getStoreById(storeId);
            Reservation reservation = store.cancelReservation(reservationId);
            System.out.println("[VehicleRentalSystem] Reservation cancelled successfully! Reservation ID: " + reservation.getId());
            return reservation;
        } catch (Exception e) {
            System.out.println("[VehicleRentalSystem] Failed to cancel reservation: " + e.getMessage());
            throw e;
        }
    }
}
