package io.github.kartiksethi.billing;

import io.github.kartiksethi.reservations.Reservation;

import java.util.Date;

public class HourlyBillingStrategy implements BillingStrategy {

    private final double hourlyRate;

    public HourlyBillingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public Bill generateBill(Reservation r) {
        Date from = r.getBookedFrom();
        Date to = r.getBookedTo();
        long diffInMillies = Math.abs(to.getTime() - from.getTime());
        long hours = diffInMillies / (1000 * 60 * 60);
        if (diffInMillies % (1000 * 60 * 60) != 0) {
            hours++;
        }
        double amount = hours * hourlyRate;
        int billId = (int) (Math.random() * 10000);
        return new Bill(billId, r.getId(), amount);
    }
}
