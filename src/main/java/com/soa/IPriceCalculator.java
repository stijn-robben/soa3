package com.soa;

import java.util.ArrayList;

public interface IPriceCalculator {

    public double calculatePrice(ArrayList<MovieTicket> tickets, boolean isStudentOrder);
}
