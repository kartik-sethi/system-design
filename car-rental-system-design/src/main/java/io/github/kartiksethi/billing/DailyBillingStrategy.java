package io.github.kartiksethi.billing;

import io.github.kartiksethi.reservations.Reservation;

import java.util.Date;

public class DailyBillingStrategy implements BillingStrategy {

    private final double dailyRate;

    public DailyBillingStrategy(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public Bill generateBill(Reservation r) {
        Date from = r.getBookedFrom();
        Date to = r.getBookedTo();
        long diffInMillies = Math.abs(to.getTime() - from.getTime());
        long days = diffInMillies / (1000 * 60 * 60 * 24);
        if (diffInMillies % (1000 * 60 * 60 * 24) != 0) {
            days++;
        }
        if (days == 0 && diffInMillies > 0) {
            days = 1;
        }
        double amount = days * dailyRate;
        int billId = (int) (Math.random() * 10000);
        return new Bill(billId, r.getId(), amount);
    }
}