import java.time.LocalDateTime;

public class MovieScreening {
    private LocalDateTime dateAndTime;
    private double pricePerSeat;
    private Movie movie;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, double pricePerSeat) {
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
        this.movie = movie;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public String toString() {
        return "Movie: " + movie + ", Date and time: " + dateAndTime + ", price per seat: " + pricePerSeat;
    }
}
