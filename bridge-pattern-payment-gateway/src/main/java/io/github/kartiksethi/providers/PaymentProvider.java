package io.github.kartiksethi.providers;

import java.util.Map;

public interface PaymentProvider {
    void processPayment(Map<String, Object> payload);
}
