package io.github.kartiksethi.payment;

import io.github.kartiksethi.enums.PaymentMode;

public class Payment {
    private final int id;
    private final int billId;
    private final double amount;
    private final PaymentMode paymentMode;

    public Payment(int id, int billId, double amount, PaymentMode paymentMode) {
        this.id = id;
        this.billId = billId;
        this.amount = amount;
        this.paymentMode = paymentMode;
    }

    public int getId() {
        return id;
    }

    public int getBillId() {
        return billId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
}