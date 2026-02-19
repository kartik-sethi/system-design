package io.github.kartiksethi.observable;

import io.github.kartiksethi.observer.Observer;

public interface Observable<T> {

    void addObserver(Observer<T> observer);

    void removeObserver(Observer<T> observer);

    void notifyObservers(T data);
}
