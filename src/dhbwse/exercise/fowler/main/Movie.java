package dhbwse.exercise.fowler.main;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    
    private String title;
    private int priceCode;
    
    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }
    
    public int getPriceCode() {
        return this.priceCode;
    }
    
    public void setPriceCode(int arg) {
        this.priceCode = arg;
    }
    
    public String getTitle (){
        return this.title;
    }
}