package dhbwse.exercise.fowler.test;

import static org.junit.jupiter.api.Assertions.*;
import dhbwse.exercise.fowler.main.Customer;
import dhbwse.exercise.fowler.main.Movie;
import dhbwse.exercise.fowler.main.Rental;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;

//import org.junit.jupiter.api.Assertions;


public class CustomerTest {

    private Customer customer;
    private ArrayList<Rental> rentals;

    @Test
    void testing(){
        customer = new Customer("Charlie");
        fillRentalList();

        String result = "Rental Record for " + customer.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental nextRental : rentals) {
            result += "\t" + nextRental.getMovie().getTitle()
                    + "\t" + "\t" + nextRental.getDaysRented()
                    + "\t" + nextRental.getCharge() + "\n";
            customer.addRental(nextRental);
        }

        result += "Amount owed is " + "38" + "\n"
                + "You earned " + "5" + " frequent renter points";

        assertThat(customer.statement(), Is.is(result));
        //Assertions.assertEquals(customer.statement(), result);
    }

    private void fillRentalList(){
        rentals = new ArrayList<>();
        rentals.add(new Rental(new Movie("Titanic", Movie.REGULAR), 3));
        rentals.add(new Rental(new Movie("Mary Poppins", Movie.NEW_RELEASE), 5));
        rentals.add(new Rental(new Movie("E.T.", Movie.CHILDRENS), 10));
        rentals.add(new Rental(new Movie("Frozen", Movie.CHILDRENS), 7));
    }

}
