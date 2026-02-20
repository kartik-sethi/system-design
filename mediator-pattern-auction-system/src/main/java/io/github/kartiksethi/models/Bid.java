package io.github.kartiksethi.models;

import io.github.kartiksethi.bidder.Bidder;

public class Bid {

    private final Bidder bidder;
    private final Item item;
    private final int bidAmount;

    public Bid(Bidder bidder, Item item, int bidAmount){
        this.bidder = bidder;
        this.item = item;
        this.bidAmount = bidAmount;
    }

    public Bidder getBidder(){ return bidder; }

    public Item getItem(){ return item; }

    public int getBidAmount(){ return bidAmount; }
}
