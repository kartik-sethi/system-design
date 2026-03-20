package io.github.kartiksethi.instruments;

import io.github.kartiksethi.providers.PaymentProvider;

import java.util.HashMap;
import java.util.Objects;

public class UPIPaymentInstrument implements PaymentInstrument{

    PaymentProvider paymentProvider;
    String upiId;

    public UPIPaymentInstrument(PaymentProvider paymentProvider, String upiId) {
        this.paymentProvider = paymentProvider;
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount);
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("upiId", upiId);
        payload.put("amount", amount);
        paymentProvider.processPayment(payload);
        System.out.println("UPI payment of $" + amount + " processed successfully for UPI ID " + upiId);
    }
}
