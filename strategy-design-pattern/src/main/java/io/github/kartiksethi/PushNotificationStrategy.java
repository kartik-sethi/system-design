package io.github.kartiksethi;

public class PushNotificationStrategy implements NotificationStrategy {

    @Override
    public void sendNotification(NotificationRequest payload) {
        System.out.println("Sending push notification: " + payload.getMessage());
    }
}
