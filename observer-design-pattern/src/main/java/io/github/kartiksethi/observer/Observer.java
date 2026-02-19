package io.github.kartiksethi.observer;

public interface Observer<T> {

    void update(T data);
}
