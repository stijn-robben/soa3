import java.util.ArrayList;

public class Order {
    int orderNr;
    boolean isStudentOrder;
    ArrayList<MovieTicket> tickets = new ArrayList<MovieTicket>(); 


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
        return 0.0; //add logic
    }

    public void export(TicketExportFormat exportFormat){
        //add logic
    }



}
