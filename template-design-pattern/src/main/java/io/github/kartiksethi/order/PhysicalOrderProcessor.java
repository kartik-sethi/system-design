package io.github.kartiksethi.order;


import io.github.kartiksethi.payment.PaymentProcessor;

public class PhysicalOrderProcessor extends TemplateOrderProcessor {

    public PhysicalOrderProcessor(PaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    protected void packItem(String orderId) {
        System.out.println("Physical: Generating shipping label and boxing the item.");
    }

    @Override
    protected void deliverItem(String orderId) {
        System.out.println("Physical: Handing package over to FedEx/UPS API.");
    }
}
