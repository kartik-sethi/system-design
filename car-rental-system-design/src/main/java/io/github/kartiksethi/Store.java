package io.github.kartiksethi;

import io.github.kartiksethi.billing.Bill;
import io.github.kartiksethi.billing.BillingManager;
import io.github.kartiksethi.enums.PaymentMode;
import io.github.kartiksethi.enums.ReservationType;
import io.github.kartiksethi.payment.Payment;
import io.github.kartiksethi.payment.PaymentManager;
import io.github.kartiksethi.reservations.Reservation;
import io.github.kartiksethi.reservations.ReservationManager;
import io.github.kartiksethi.vehicle.Vehicle;
import io.github.kartiksethi.vehicle.VehicleInventoryManager;

import java.util.Date;

public class Store {
    private final int id;
    private final String name;
    private final Location location;
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final PaymentManager paymentManager;
    private final BillingManager billingManager;
    private ReservationType reservationType;

    public Store(int id, String name, Location location){
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicleInventoryManager = new VehicleInventoryManager();
        this.reservationManager = new ReservationManager();
        this.reservationType = ReservationType.DAILY;
        this.billingManager = new BillingManager();
        this.paymentManager = new PaymentManager();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Reservation reserveVehicle(int userId, int vehicleId, Date from, Date to){
        Vehicle vehicle = vehicleInventoryManager.reserveVehicle(vehicleId);
        Reservation reservation  = reservationManager.addReservation(getId(), vehicleId,userId,  from, to, ReservationType.DAILY);
        return reservation;
    }

    public Bill generateBill(int reservationId){
        Reservation reservation = reservationManager.findById(reservationId);
        return billingManager.generateBill(reservation);
    }

    public Payment makePayment(Bill bill, double amount, PaymentMode paymentMode){
        Payment payment = paymentManager.processPayment(bill, amount, paymentMode);
        return payment;
    }

    public Reservation cancelReservation(int reservationId){
        Reservation reservation = reservationManager.cancelReservation(reservationId);
        return reservation;
    }

    public boolean isAvailable(int vehicleId){
        return vehicleInventoryManager.isVehicleAvailable(vehicleId);
    }

    public Vehicle addVehicle(String number){
        return vehicleInventoryManager.addVehicle(number);
    }

    public void removeVehicle(int vehicleId){
        vehicleInventoryManager.removeVehicle(vehicleId);
    }


}
