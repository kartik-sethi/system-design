package io.github.kartiksethi.payment;

public class PaypalPaymentProcessor extends TemplatePaymentProcessor {

    @Override
    protected void validatePayment() {
        System.out.println("Paypal: Validating payment details...");
    }

    @Override
    protected String executePayment(double amount) {
        System.out.println("Paypal: Processing payment of $" + amount);
        return "Paypal_Txn_12345";
    }
}
