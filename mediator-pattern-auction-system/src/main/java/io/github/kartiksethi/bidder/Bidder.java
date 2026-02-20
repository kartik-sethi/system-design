package io.github.kartiksethi.bidder;

public interface Bidder {

    void placeBid(int amount);

    void receiveNotification(String message);

    String getName();
}
