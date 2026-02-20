package io.github.kartiksethi.mediator;

import io.github.kartiksethi.bidder.Bidder;
import io.github.kartiksethi.models.Bid;
import io.github.kartiksethi.models.Item;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediatorImpl implements AuctionMediator{

    private final List<Bidder> bidders;
    private final Item item;
    private Bid currentBid;

    public AuctionMediatorImpl(Item item){
        this.item = item;
        this.bidders = new ArrayList<>();
    }

    @Override
    public void addBidder(Bidder bidder){
        bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int amount){
        if(amount <= 0) {
            bidder.receiveNotification("Invalid bid amount");
        } else if(currentBid != null && currentBid.getBidAmount() >= amount){
            bidder.receiveNotification("Your bid is lower than the current bid : "+ currentBid.getBidAmount());
        } else {
            this.currentBid = new Bid(bidder, item, amount);
            sendNotification("New bid placed by: "+ bidder.getName()+" with amount: " + amount);
        }
    }

    @Override
    public void sendNotification(String message){
        for(Bidder curr: bidders){
            curr.receiveNotification(message);
        }
    }

    @Override
    public Item getItem(){
        return item;
    }
}
