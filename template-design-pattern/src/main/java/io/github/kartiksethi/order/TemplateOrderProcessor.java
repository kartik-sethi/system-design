package io.github.kartiksethi.order;

import io.github.kartiksethi.payment.PaymentProcessor;

public abstract class TemplateOrderProcessor {

    private final PaymentProcessor paymentProcessor;

    public TemplateOrderProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public final void processOrder(String orderId, double amount) {
        if (!checkInventory(orderId)) {
            throw new RuntimeException("Out of stock!");
        }

        paymentProcessor.processPayment(amount);
        logOrderStart(orderId);
        packItem(orderId);
        deliverItem(orderId);
        notifyCustomer(orderId);
    }

    private boolean checkInventory(String orderId) {
        System.out.println("Checking database for inventory availability...");
        return true;
    }

    private void logOrderStart(String orderId) {
        System.out.println("Audit Log: Starting fulfillment for order " + orderId);
    }

    private void notifyCustomer(String orderId) {
        System.out.println("Pushing 'Order Complete' event to Kafka/Notification Service.");
    }

    protected abstract void packItem(String orderId);
    protected abstract void deliverItem(String orderId);
}
