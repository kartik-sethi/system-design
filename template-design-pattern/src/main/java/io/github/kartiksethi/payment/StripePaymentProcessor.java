package io.github.kartiksethi.payment;

public class StripePaymentProcessor extends TemplatePaymentProcessor {

    @Override
    protected void validatePayment() {
        System.out.println("Stripe: Validating payment details...");
    }

    @Override
    protected String executePayment(double amount) {
        System.out.println("Stripe: Processing payment...");
        return "Stripe_Txn_12345";
    }
}