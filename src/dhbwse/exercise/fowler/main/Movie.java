package dhbwse.exercise.fowler.main;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    
    private String title;
    private int priceCode;
    private Price price;
    
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }
    
    public int getPriceCode() {
        return this.price.getPriceCode();
    }
    
    public void setPriceCode(int arg) {
        switch (arg) {
		case REGULAR:
			this.price = new RegularPrice();
			break;
		case CHILDRENS:
			this.price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			this.price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
    }
    
    public String getTitle (){
        return this.title;
    }
    
    public double getCharge(int daysRented) {
		return this.price.getCharge(daysRented);
	}
    
    public int getFrequentRenterPoints(int daysRented) {
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}