package io.github.kartiksethi.payment;

import io.github.kartiksethi.billing.Bill;
import io.github.kartiksethi.enums.PaymentMode;

public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public Payment makePayment(Bill bill, double amount) {
        int paymentId = (int) (Math.random() * 10000);
        return new Payment(paymentId, bill.getId(), amount, PaymentMode.UPI);
    }
}