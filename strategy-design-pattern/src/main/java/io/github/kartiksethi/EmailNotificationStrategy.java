package io.github.kartiksethi;

public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void sendNotification(NotificationRequest payload) {
        System.out.println("Sending email notification: " + payload.getMessage());
    }
}
