package dhbwse.exercise.fowler.main;

public class Rental {
    private Movie movie;
    private int daysRented;
    
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return this.daysRented;
    }
    
    public Movie getMovie() {
        return this.movie;
    }
    
    public double getCharge() {
		return this.movie.getCharge(this.daysRented);
	}
    
    public int getFrequentRenterPoints() {
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}