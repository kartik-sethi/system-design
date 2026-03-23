package io.github.kartiksethi;

public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public void sendNotification(NotificationRequest payload) {
        System.out.println("Sending SMS notification: " + payload.getMessage());
    }
}
