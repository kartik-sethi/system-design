package io.github.kartiksethi;

import io.github.kartiksethi.observable.IphonePriceObservableImpl;
import io.github.kartiksethi.observable.StockPriceObservable;
import io.github.kartiksethi.observer.EmailNotificationObserverImpl;
import io.github.kartiksethi.observer.MobileNotificationObserverImpl;
import io.github.kartiksethi.observer.NotificationObserver;

public class Main {
    public static void main(String[] args) {
        StockPriceObservable iphoneObservable = new IphonePriceObservableImpl();

        NotificationObserver<Integer> observer1 = new EmailNotificationObserverImpl("xyz@gmail.com");
        NotificationObserver<Integer> observer2 = new EmailNotificationObserverImpl("xyz1@gmail.com");
        NotificationObserver<Integer> observer3 = new MobileNotificationObserverImpl("1344345343");

        iphoneObservable.addObserver(observer1);
        iphoneObservable.addObserver(observer2);
        iphoneObservable.addObserver(observer3);
        iphoneObservable.setStockPrice(10);
    }
}