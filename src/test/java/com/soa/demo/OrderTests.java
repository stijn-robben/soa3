package com.soa.demo;

import org.junit.jupiter.api.Test;
import com.soa.Movie;
import com.soa.MovieScreening;
import com.soa.MovieTicket;
import com.soa.Order;
import com.soa.TicketExportFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;

public class OrderTests {

    @Test
    void testAlwaysTrue() {
        assertTrue(true, "This test will always pass");
    }

    @Test
    void testCalculatePrice() {
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