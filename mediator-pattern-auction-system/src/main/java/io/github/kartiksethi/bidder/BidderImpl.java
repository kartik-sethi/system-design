package io.github.kartiksethi.bidder;

import io.github.kartiksethi.mediator.AuctionMediator;

public class BidderImpl implements Bidder{

    private final String name;
    private final AuctionMediator auctionMediator;

    public BidderImpl(String name, AuctionMediator auctionMediator){
        this.name = name;
        this.auctionMediator = auctionMediator;
    }

    @Override
    public void placeBid(int amount){
        auctionMediator.placeBid(this, amount);
    }

    @Override
    public void receiveNotification(String message){
        System.out.println("Hello "+ name+ " "+message);
    }

    @Override
    public String getName(){
        return name;
    }
}
