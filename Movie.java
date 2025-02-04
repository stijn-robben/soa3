public class Movie {
    private String title;
    private MovieScreening[] screenings;

    public Movie(String title) {
        this.title = title;
    }

    public void addScreening(MovieScreening screening) {
        // Add the screening to the array of screenings
        if (screenings == null) {
            screenings = new MovieScreening[1];
            screenings[0] = screening;
        } else {
            MovieScreening[] newScreenings = new MovieScreening[screenings.length + 1];
            for (int i = 0; i < screenings.length; i++) {
                newScreenings[i] = screenings[i];
            }
            newScreenings[screenings.length] = screening;
            screenings = newScreenings;
        }
    }

    public String toString() {
        return title;
    }
}
