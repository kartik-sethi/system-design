package io.github.kartiksethi.payment;

import io.github.kartiksethi.billing.Bill;
import io.github.kartiksethi.enums.PaymentMode;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentManager {

    private final ConcurrentHashMap<Integer, Payment> payments = new ConcurrentHashMap<>();
    private final HashMap<PaymentMode, PaymentStrategy> paymentStrategy;

    public PaymentManager() {
        paymentStrategy = new HashMap<>();
        paymentStrategy.put(PaymentMode.CARD, new CardPaymentStrategy());
        paymentStrategy.put(PaymentMode.UPI, new UPIPaymentStrategy());
    }

    public Payment processPayment(Bill bill, double amount, PaymentMode mode) {
        PaymentStrategy strategy = paymentStrategy.get(mode);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment mode: " + mode);
        }
        Payment payment = strategy.makePayment(bill, amount);
        payments.put(payment.getId(), payment);
        return payment;
    }

    public Payment getPaymentDetails(int paymentId) {
        return payments.get(paymentId);
    }
}