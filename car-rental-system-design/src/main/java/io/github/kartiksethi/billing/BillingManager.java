package io.github.kartiksethi.billing;

import io.github.kartiksethi.reservations.Reservation;
import io.github.kartiksethi.enums.ReservationType;

import java.util.concurrent.ConcurrentHashMap;

public class BillingManager {

    private final ConcurrentHashMap<Integer, Bill> bills = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<ReservationType, BillingStrategy> billingStrategies = new ConcurrentHashMap<>();

    public BillingManager(){
        billingStrategies.put(ReservationType.HOURLY, new HourlyBillingStrategy(10));
        billingStrategies.put(ReservationType.DAILY, new DailyBillingStrategy(200));
    }

    public Bill generateBill(Reservation r){
        Bill bill = billingStrategies.get(r.getReservationType()).generateBill(r);
        return bill;
    }
}
