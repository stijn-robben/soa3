package com.soa;

import java.util.ArrayList;

public class PriceCalculator implements IPriceCalculator {

    @Override
    public double calculatePrice(ArrayList<MovieTicket> tickets, boolean isStudentOrder) {
        double totalPrice = 0;
        for (MovieTicket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        if (isStudentOrder) {
            totalPrice *= 0.8; // Verander 1 naar bv. 0.8 om 20% korting te krijgen voor studenten.
        }
        return totalPrice;
    }
    
}
