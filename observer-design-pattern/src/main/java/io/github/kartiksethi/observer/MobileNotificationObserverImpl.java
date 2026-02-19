package io.github.kartiksethi.observer;

public class MobileNotificationObserverImpl implements NotificationObserver<Integer> {

    private final String mobileNumber;

    public MobileNotificationObserverImpl(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void update(Integer data) {
       sendNotification(data);
    }

    @Override
    public void sendNotification(Integer data) {
        System.out.println(mobileNumber + ":  Product price is updated to: "+ data);
    }
}
