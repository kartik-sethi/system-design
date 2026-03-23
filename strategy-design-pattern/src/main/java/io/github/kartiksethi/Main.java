package io.github.kartiksethi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationStrategy emailAlgo = new EmailNotificationStrategy();
        NotificationStrategy smsAlgo = new SmsNotificationStrategy();
        NotificationStrategy pushAlgo = new PushNotificationStrategy();

        NotificationContext context = new NotificationContext(emailAlgo);
        context.sendNotification(new NotificationRequest("Hello World!"));

        context.setStrategy(smsAlgo);
        context.sendNotification(new NotificationRequest("Hello World!"));

        context.setStrategy(pushAlgo);
        context.sendNotification(new NotificationRequest("Hello World!"));
    }
}