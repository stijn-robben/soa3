package com.soa;

public interface IMovieTicket {
    public boolean isPremiumTicket();
    public double getPrice();
    public String toString();
    public String toJson();
}
