package io.github.kartiksethi.observable;

public interface StockPriceObservable
        extends Observable<Integer> {

    void setStockPrice(int price);

    int getStockPrice();
}
