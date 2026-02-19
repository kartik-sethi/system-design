package io.github.kartiksethi.observable;

import io.github.kartiksethi.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphonePriceObservableImpl implements StockPriceObservable {

    private final List<Observer<Integer>> observerList = new ArrayList<>();
    private int stockPrice = 0;

    @Override
    public void addObserver(Observer<Integer> observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer<Integer> observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Integer data) {
        for (Observer<Integer> observer : observerList) {
            observer.update(data);
        }
    }

    @Override
    public void setStockPrice(int stockPrice) {
        if (this.stockPrice != stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers(stockPrice);
        }
    }

    @Override
    public int getStockPrice() {
        return stockPrice;
    }
}
