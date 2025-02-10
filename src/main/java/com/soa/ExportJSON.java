package com.soa;

public class ExportJSON implements IExportmanager{

    @Override
    public String export(Order order) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"orderNr\": ").append(order.getOrderNr()).append(",\n");
        json.append("  \"isStudentOrder\": ").append(order.isStudentOrder()).append(",\n");
        json.append("  \"totalPrice\": ").append(order.calculatePrice()).append(",\n");
        json.append("  \"tickets\": [\n");
        for (int i = 0; i < order.getTickets().size(); i++) {
            json.append("    ").append(order.getTickets().get(i).toJson());
            if (i < order.getTickets().size() - 1) json.append(",");
            json.append("\n");
        }
        json.append("  ]\n");
        json.append("}");
        return json.toString();
    }
    
}
