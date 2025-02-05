public class MovieTicket {
    int rowNr;
    int seatNr;
    boolean isPremium;
    MovieScreening movieScreening;

    public MovieTicket(MovieScreening movieScreening, boolean isPremiumReservation, int seatRow, int seatNr) {
        this.rowNr = seatRow;
        this.seatNr = seatNr;
        this.isPremium = isPremiumReservation;
        this.movieScreening = movieScreening;
    }

    public boolean isPremiumTicket(){
        return isPremium;
    }

    public double getPrice() {
        return movieScreening.getPricePerSeat();
    }

    public String toString() {
        return movieScreening.toString() + ", seat: " + rowNr + seatNr;
    }

    public String toJson() {
        return "{ \"row\": " + rowNr + ", \"seat\": " + seatNr + ", \"isPremium\": " + isPremium + " }";
    }
    
}
