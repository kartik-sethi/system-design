package io.github.kartiksethi.billing;

import io.github.kartiksethi.reservations.Reservation;

public interface BillingStrategy {

    Bill generateBill(Reservation r);
}
