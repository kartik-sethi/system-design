package io.github.kartiksethi;

import io.github.kartiksethi.instruments.CardPaymentInstrument;
import io.github.kartiksethi.instruments.PaymentInstrument;
import io.github.kartiksethi.instruments.UPIPaymentInstrument;
import io.github.kartiksethi.providers.PaymentProvider;
import io.github.kartiksethi.providers.PaypalPaymentProvider;
import io.github.kartiksethi.providers.StripePaymentProvider;

public class Main {
    public static void main(String[] args) {
        PaymentProvider stripePaymentProvider = new StripePaymentProvider();
        PaymentProvider payPalPaymentProvider = new PaypalPaymentProvider();

        PaymentInstrument card = new CardPaymentInstrument(stripePaymentProvider, "1234");

        PaymentInstrument upi = new UPIPaymentInstrument(payPalPaymentProvider, "5678");
        card.processPayment(10);
        upi.processPayment(1);

    }
}