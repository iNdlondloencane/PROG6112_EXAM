package question2;

// This class calculates the VAT, commission and total sale amount
public class ProductCalculations implements IProductCalculations {

    // Constants for the rates so there are no magic numbers in the code
    private final double VAT_RATE = 0.15;
    private final double COMMISSION_RATE = 0.05;

    private double price;

    // Constructors receiving the product price
    public ProductCalculations(double price) {
        this.price = price;
    }

    // VAT is 15%
    public double GetVat() {
        return price * VAT_RATE;
    }

    // Commission is 5%
    public double GetCommission() {
        return price * COMMISSION_RATE;
    }

    // Total sale amount = price + VAT + commission
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}
