package io.github.kartiksethi.observer;

public interface NotificationObserver<T> extends Observer<T> {

    void sendNotification(T data);
}
