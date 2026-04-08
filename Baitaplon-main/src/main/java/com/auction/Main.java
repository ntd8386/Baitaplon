package com.auction;

import com.auction.model.*;
import com.auction.service.*;

public class Main {
    public static void main(String[] args) {

        AuctionService service = new AuctionService();

        Bidder b = new Bidder(1, "dat", "123", "a@gmail.com", 1000);

        Item item = new Electronics(1, "Laptop", 100);
        Auction auction = new Auction(item);

        service.placeBid(auction, new Bid(b, 150));
        service.placeBid(auction, new Bid(b, 200));

        service.printBids(auction);

        service.endAuction(auction);
    }
}