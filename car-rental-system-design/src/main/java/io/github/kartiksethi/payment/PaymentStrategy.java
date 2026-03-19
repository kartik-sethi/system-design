package io.github.kartiksethi.payment;

import io.github.kartiksethi.billing.Bill;

public interface PaymentStrategy {

    Payment makePayment(Bill bill, double amount);
}
