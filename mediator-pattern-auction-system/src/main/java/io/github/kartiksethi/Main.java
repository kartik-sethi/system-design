package io.github.kartiksethi;

import io.github.kartiksethi.bidder.Bidder;
import io.github.kartiksethi.bidder.BidderImpl;
import io.github.kartiksethi.mediator.AuctionMediator;
import io.github.kartiksethi.mediator.AuctionMediatorImpl;
import io.github.kartiksethi.models.Item;

public class Main {
    public static void main(String[] args) {
        Item item = new Item("Rolex watch");

        AuctionMediator auctionMediator = new AuctionMediatorImpl(item);
        Bidder bidder1 = new BidderImpl("bidder1", auctionMediator);
        Bidder bidder2 = new BidderImpl("bidder2", auctionMediator);
        Bidder bidder3 = new BidderImpl("bidder3", auctionMediator);

        auctionMediator.addBidder(bidder1);
        auctionMediator.addBidder(bidder2);
        auctionMediator.addBidder(bidder3);

        bidder1.placeBid(10);
        bidder2.placeBid(20);
        bidder3.placeBid(15);
    }
}