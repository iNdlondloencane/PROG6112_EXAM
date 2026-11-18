package question2;

import org.junit.Test;
import static org.junit.Assert.*;

// Unit tests for the ProductCalculations class
public class ProductCalculationsTest {

    // Checks that the VAT for the price
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calculations = new ProductCalculations(3500);

        double expected = 525.0;
        double actual = calculations.GetVat();

        assertEquals(expected, actual, 0.001);
    }

    // Checks that the total for the price
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calculations = new ProductCalculations(3500);

        double expected = 4200.0;
        double actual = calculations.GetTotal();

        assertEquals(expected, actual, 0.001);
    }
}
