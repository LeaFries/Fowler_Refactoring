package dhbwse.exercise.fowler.test;

import dhbwse.exercise.fowler.main.Customer;
import dhbwse.exercise.fowler.main.Movie;
import dhbwse.exercise.fowler.main.Rental;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.Assertions;


public class CustomerTest {

    private Customer customer;
    private ArrayList<Rental> rentals;

    @Test
    void testing(){
        customer = new Customer("Charlie");
        fillRentalList();
        
        for (Rental nextRental : rentals) {
          customer.addRental(nextRental);
        }

        String result = "Rental Record for " + customer.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
        result += "\tTitanic\t\t3\t3.5\n"
        		+ "\tMary Poppins\t\t5\t15.0\n"
        		+ "\tE.T.\t\t10\t12.0\n"
        		+ "\tFrozen\t\t7\t7.5\n"
        		+ "Amount owed is 38.0\n"
        		+ "You earned 5 frequent renter points";
        
//        for (Rental nextRental : rentals) {
//            result += "\t" + nextRental.getMovie().getTitle()
//                    + "\t" + "\t" + nextRental.getDaysRented()
//                    + "\t" + nextRental.getCharge() + "\n";
//            customer.addRental(nextRental);
//        }
        
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
