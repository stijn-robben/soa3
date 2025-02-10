package com.soa;

import java.util.ArrayList;

public interface IOrder {

    int getOrderNr();
    boolean isStudentOrder();
    ArrayList<MovieTicket> getTickets();
    void addSeatReservation(MovieTicket movieTicket);
    double calculatePrice();
    void export(IExportmanager exportManager, TicketExportFormat exportFormat);
}
