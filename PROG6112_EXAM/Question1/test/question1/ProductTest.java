package question1;

import org.junit.Test;
import static org.junit.Assert.*;

// Unit tests for the Product class
public class ProductTest {

    // Test data from the sample in the question
    String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};

    // Checks that the total of all the sales
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product mattresses = new Product(names, sales);

        int expected = 153;
        int actual = mattresses.GetTotalProductsSold();

        assertEquals(expected, actual);
    }

    // Checks that the average
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product mattresses = new Product(names, sales);

        double expected = 17.0;
        double actual = mattresses.GetAverageProductSold();

        assertEquals(expected, actual, 0.001);
    }
}
