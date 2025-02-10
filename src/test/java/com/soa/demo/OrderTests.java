package com.soa.demo;

import org.junit.jupiter.api.Test;

import com.soa.IPriceCalculator;
import com.soa.Movie;
import com.soa.MovieScreening;
import com.soa.MovieTicket;
import com.soa.Order;
import com.soa.PriceCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

class OrderTests {

    IPriceCalculator priceCalculator = new PriceCalculator();

    @Test
    void calculatePriceTwoTicketsStudents() {
        Movie movie = new Movie("Inception");
        LocalDateTime screeningTime = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening = new MovieScreening(movie, screeningTime, 12.50);
        Order order = new Order(1, true, priceCalculator);

        MovieTicket ticket1 = new MovieTicket(screening, false, 5, 8);
        MovieTicket ticket2 = new MovieTicket(screening, true, 5, 9);

        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double totalPrice = order.calculatePrice();
        assertEquals(20.0, totalPrice, "Total price should be 20.0");
    }


    @Test
    void calculatePriceNoTickets() {
        Order order = new Order(1, false, priceCalculator);
        double totalPrice = order.calculatePrice();
        assertEquals(0.0, totalPrice, "Total price should be 0.0");
    }

    @Test
    void calculatePriceTwoTickets() {
        Movie movie = new Movie("Inception");
        LocalDateTime screeningTime = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening = new MovieScreening(movie, screeningTime, 12.50);
        Order order = new Order(1, false, priceCalculator);

        MovieTicket ticket1 = new MovieTicket(screening, false, 5, 8);
        MovieTicket ticket2 = new MovieTicket(screening, true, 5, 9);

        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double totalPrice = order.calculatePrice();
        assertEquals(25.0, totalPrice, "Total price should be 25.0");
    }

    @Test
    void calculatePriceTwoTicketsButDifferentMovies() {
        Movie movie1 = new Movie("Inception");
        LocalDateTime screeningTime1 = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening1 = new MovieScreening(movie1, screeningTime1, 12.50);

        Movie movie2 = new Movie("Interstellar");
        LocalDateTime screeningTime2 = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening2 = new MovieScreening(movie2, screeningTime2, 15.0);

        Order order = new Order(1, false, priceCalculator);

        MovieTicket ticket1 = new MovieTicket(screening1, false, 5, 8);
        MovieTicket ticket2 = new MovieTicket(screening2, true, 5, 9);

        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double totalPrice = order.calculatePrice();
        assertEquals(27.5, totalPrice, "Total price should be 27.5");
    }

    @Test
void calculatePriceNoTicketsStudent() {
    Order order = new Order(1, true, priceCalculator);
    double totalPrice = order.calculatePrice();
    assertEquals(0.0, totalPrice, "Total price should be 0.0 for a student order with no tickets");
}
}