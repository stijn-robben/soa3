package com.soa;

public class ExportText implements IExportmanager {

    @Override
    public String export(Order order) {
        StringBuilder plainText = new StringBuilder();
        plainText.append("Order Number: ").append(order.getOrderNr()).append("\n");
        plainText.append("Student Order: ").append(order.isStudentOrder() ? "Yes" : "No").append("\n");
        plainText.append("Total Price: ").append(order.calculatePrice()).append("\n");
        plainText.append("Tickets:\n");
        for (MovieTicket ticket : order.getTickets()) {
            plainText.append("  - ").append(ticket.toString()).append("\n");
        }
        return plainText.toString();
    }
    
}
