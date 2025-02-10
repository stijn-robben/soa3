package com.soa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order implements IOrder {

    private int orderNr;
    private boolean isStudentOrder;
    private ArrayList<MovieTicket> tickets = new ArrayList<>();
    private IPriceCalculator priceCalculator;

    public Order(int orderNr, boolean isStudentOrder, IPriceCalculator priceCalculator) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        this.priceCalculator = priceCalculator;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public boolean isStudentOrder() {
        return isStudentOrder;
    }

    public ArrayList<MovieTicket> getTickets() {
        return tickets;
    }

    public void addSeatReservation(MovieTicket movieTicket) {
        tickets.add(movieTicket);
    }

    public double calculatePrice() {
        return this.priceCalculator.calculatePrice(tickets, isStudentOrder);
    }

    public void export(IExportmanager exportManager, TicketExportFormat exportFormat) {
        String exportedData;
        exportedData = exportManager.export(this);
        writeFile(exportedData, exportFormat);
    }

    private void writeFile(String data, TicketExportFormat format) {
        String directory = "exports";
        File exportFolder = new File(directory);
        if (!exportFolder.exists()) {
            exportFolder.mkdir();
        }

        String fileName = directory + "/order_" + orderNr + (format == TicketExportFormat.JSON ? ".json" : ".txt");
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data);
            System.out.println("Order exported successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
