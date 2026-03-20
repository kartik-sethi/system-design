package io.github.kartiksethi.providers;

import java.util.Map;

public class StripePaymentProvider implements PaymentProvider{

    @Override
    public void processPayment(Map<String, Object> payload) {
        System.out.println("Successfully processed Stripe payment of $" + payload.get("amount"));
    }

}
