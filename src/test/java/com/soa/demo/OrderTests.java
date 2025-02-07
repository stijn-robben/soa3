package com.soa.demo;

import org.junit.jupiter.api.Test;
import com.soa.Movie;
import com.soa.MovieScreening;
import com.soa.MovieTicket;
import com.soa.Order;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

public class OrderTests {

    @Test
    void calculatePriceTwoTicketsStudents() {
        Movie movie = new Movie("Inception");
        LocalDateTime screeningTime = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening = new MovieScreening(movie, screeningTime, 12.50);
        Order order = new Order(1, true);

        MovieTicket ticket1 = new MovieTicket(screening, false, 5, 8);
        MovieTicket ticket2 = new MovieTicket(screening, true, 5, 9);

        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double totalPrice = order.calculatePrice();
        assertEquals(20.0, totalPrice, "Total price should be 20.0");
    }

    @Test
    void calculatePriceOneTicket() {
        Movie movie = new Movie("Inception");
        LocalDateTime screeningTime = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening = new MovieScreening(movie, screeningTime, 12.50);
        Order order = new Order(1, false);

        MovieTicket ticket = new MovieTicket(screening, false, 5, 8);
        order.addSeatReservation(ticket);

        double totalPrice = order.calculatePrice();
        assertEquals(12.50, totalPrice, "Total price should be 12.50");
    }

    @Test
    void calculatePriceNoTickets() {
        Order order = new Order(1, false);
        double totalPrice = order.calculatePrice();
        assertEquals(0.0, totalPrice, "Total price should be 0.0");
    }

    @Test
    void calculatePriceTwoTickets() {
        Movie movie = new Movie("Inception");
        LocalDateTime screeningTime = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening = new MovieScreening(movie, screeningTime, 12.50);
        Order order = new Order(1, false);

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

        Order order = new Order(1, false);

        MovieTicket ticket1 = new MovieTicket(screening1, false, 5, 8);
        MovieTicket ticket2 = new MovieTicket(screening2, true, 5, 9);

        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        double totalPrice = order.calculatePrice();
        assertEquals(27.5, totalPrice, "Total price should be 27.5");
    }

    @Test
    void testExportToJson() {
        Movie movie = new Movie("Inception");
        LocalDateTime screeningTime = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening = new MovieScreening(movie, screeningTime, 12.50);
        Order order = new Order(1, false);

        MovieTicket ticket1 = new MovieTicket(screening, false, 5, 8);
        MovieTicket ticket2 = new MovieTicket(screening, true, 5, 9);

        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);

        String json = order.toJson();
        assertTrue(json.contains("\"orderNr\": 1"), "JSON should contain order number");
        assertTrue(json.contains("\"totalPrice\": 25.0"), "JSON should contain total price");
    }
}