package com.auction.service;

import com.auction.model.*;
import java.util.*;

public class AuctionService {

    public boolean placeBid(Auction auction, Bid bid) {

        if (auction.getStatus() != AuctionStatus.OPEN) {
            System.out.println("Auction not open!");
            return false;
        }

        if (bid.getAmount() <= auction.getCurrentPrice()) {
            System.out.println("Bid must be higher!");
            return false;
        }

        if (bid.getBidder().getBalance() < bid.getAmount()) {
            System.out.println("Not enough money!");
            return false;
        }

        auction.getBids().add(bid);
        auction.setCurrentPrice(bid.getAmount());

        return true;
    }

    public Bid getWinner(Auction auction) {
        List<Bid> bids = auction.getBids();
        if (bids.isEmpty()) return null;
        return bids.get(bids.size() - 1);
    }

    public void endAuction(Auction auction) {
        auction.setStatus(AuctionStatus.FINISHED);

        Bid winner = getWinner(auction);

        if (winner != null) {
            System.out.println("Winner: " + winner.getBidder().getName());

            Bidder b = winner.getBidder();
            b.setBalance(b.getBalance() - winner.getAmount());
        }
    }

    public void printBids(Auction auction) {
        for (Bid b : auction.getBids()) {
            System.out.println(
                    b.getBidder().getName() + " : " + b.getAmount()
            );
        }
    }
}