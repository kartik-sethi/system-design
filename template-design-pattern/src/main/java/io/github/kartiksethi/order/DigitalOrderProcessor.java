package io.github.kartiksethi.order;

import io.github.kartiksethi.payment.PaymentProcessor;

public class DigitalOrderProcessor extends TemplateOrderProcessor {

    public DigitalOrderProcessor(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    protected void packItem(String orderId) {
        System.out.println("Digital: Generating a unique software license key.");
    }

    @Override
    protected void deliverItem(String orderId) {
        System.out.println("Digital: Emailing the secure download link and key to user.");
    }

}
