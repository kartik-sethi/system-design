package io.github.kartiksethi;

public class NotificationContext {

    private NotificationStrategy strategy;

    public  NotificationContext(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendNotification(NotificationRequest payload) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        strategy.sendNotification(payload);
    }
}
