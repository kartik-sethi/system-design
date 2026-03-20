package io.github.kartiksethi.instruments;

import io.github.kartiksethi.providers.PaymentProvider;

import java.util.HashMap;

public class CardPaymentInstrument implements PaymentInstrument{

    PaymentProvider paymentProvider;
    String cardNumber;

    public CardPaymentInstrument(PaymentProvider paymentProvider, String cardNumber) {
        this.paymentProvider = paymentProvider;
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing card payment of $" + amount +  " for card " + cardNumber);
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("cardNumber", cardNumber);
        payload.put("amount", amount);
        paymentProvider.processPayment(payload);
        System.out.println("Card payment of $" + amount + " processed successfully for card " + cardNumber);
    }
}
