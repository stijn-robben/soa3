package com.soa;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        IPriceCalculator priceCalculator = new PriceCalculator();
        ExportJSON exportJSON = new ExportJSON();
        ExportText exportPlainText = new ExportText();

        Movie movie = new Movie("Inception");
        
        LocalDateTime screeningTime = LocalDateTime.of(2025, 2, 10, 19, 30);
        MovieScreening screening = new MovieScreening(movie, screeningTime, 12.50);
        movie.addScreening(screening);
        IOrder order = new Order(1, false, priceCalculator);
        
        MovieTicket ticket1 = new MovieTicket(screening, false, 5, 8);
        MovieTicket ticket2 = new MovieTicket(screening, true, 5, 9);
        
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.export(exportPlainText, TicketExportFormat.PLAINTEXT);
        order.export(exportJSON, TicketExportFormat.JSON);
    }
}