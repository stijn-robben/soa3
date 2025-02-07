package com.soa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {

    int orderNr;
    boolean isStudentOrder;
    ArrayList<MovieTicket> tickets = new ArrayList<>();

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket movieTicket) {
        tickets.add(movieTicket);
    }

    public double calculatePrice() {
        double totalPrice = 0;
        for (MovieTicket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        if (isStudentOrder) {
            totalPrice *= 1; // Verander 1 naar bv. 0.8 om 20% korting te krijgen voor studenten.
        }
        return totalPrice;
    }

    public void export(TicketExportFormat exportFormat) {
        String exportedData;
        if (exportFormat == TicketExportFormat.JSON) {
            exportedData = toJson();
        } else if (exportFormat == TicketExportFormat.PLAINTEXT) {
            exportedData = toPlainText();
        } else {
            throw new IllegalArgumentException("Unsupported export format");
        }
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

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"orderNr\": ").append(orderNr).append(",\n");
        json.append("  \"isStudentOrder\": ").append(isStudentOrder).append(",\n");
        json.append("  \"totalPrice\": ").append(calculatePrice()).append(",\n");
        json.append("  \"tickets\": [\n");
        for (int i = 0; i < tickets.size(); i++) {
            json.append("    ").append(tickets.get(i).toJson());
            if (i < tickets.size() - 1) json.append(",");
            json.append("\n");
        }
        json.append("  ]\n");
        json.append("}");
        return json.toString();
    }

    public String toPlainText() {
        StringBuilder plainText = new StringBuilder();
        plainText.append("Order Number: ").append(orderNr).append("\n");
        plainText.append("Student Order: ").append(isStudentOrder ? "Yes" : "No").append("\n");
        plainText.append("Total Price: ").append(calculatePrice()).append("\n");
        plainText.append("Tickets:\n");
        for (MovieTicket ticket : tickets) {
            plainText.append("  - ").append(ticket.toString()).append("\n");
        }
        return plainText.toString();
    }
}
