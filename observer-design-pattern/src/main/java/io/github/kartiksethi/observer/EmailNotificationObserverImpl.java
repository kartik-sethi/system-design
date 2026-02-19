package io.github.kartiksethi.observer;

public class EmailNotificationObserverImpl implements NotificationObserver<Integer>{
    private final String emailId;

    public EmailNotificationObserverImpl(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void update(Integer data) {
        sendNotification(data);
    }

    @Override
    public void sendNotification(Integer data) {
        System.out.println(emailId + ":  Product price is updated to: "+ data);
    }
}

