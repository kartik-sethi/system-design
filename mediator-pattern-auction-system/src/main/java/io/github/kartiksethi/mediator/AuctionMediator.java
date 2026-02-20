package io.github.kartiksethi.mediator;

import io.github.kartiksethi.bidder.Bidder;
import io.github.kartiksethi.models.Item;

public interface AuctionMediator {

    void addBidder(Bidder bidder);

    void placeBid(Bidder bidder, int amount);

    void sendNotification(String message);

    Item getItem();
}
