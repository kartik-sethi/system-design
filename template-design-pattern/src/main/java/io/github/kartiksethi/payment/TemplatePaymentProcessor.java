package io.github.kartiksethi.payment;

public abstract class TemplatePaymentProcessor implements PaymentProcessor {
    public final void processPayment(double amount){
        logTransaction(amount);
        validatePayment();
        String receipt = executePayment(amount);
        saveTransactionToDb(receipt);
        sendReceiptToUser(receipt);
    }

    private void logTransaction(double amount) { System.out.println("Logging transaction for amount: " + amount); }

    protected abstract void validatePayment();

    protected abstract String executePayment(double amount);

    private void saveTransactionToDb(String receipt){
        System.out.println("Successfully saved transaction to db for receipt: "+ receipt);
    }

    private void sendReceiptToUser(String receipt){
        System.out.println("Successfully sent receipt to user for receipt: "+ receipt);
    }
}
