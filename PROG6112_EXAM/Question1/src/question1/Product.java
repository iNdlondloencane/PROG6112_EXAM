package question1;

// The Product class does the calculations for the sales report
public class Product implements IProduct {

    // Constants for the number of products and months
    private final int NUM_PRODUCTS = 3;
    private final int NUM_MONTHS = 3;

    // Single array to store the product names
    private String[] productNames = new String[NUM_PRODUCTS];

    // Two-dimensional array to store the sales (rows = products, columns = months)
    private int[][] sales = new int[NUM_PRODUCTS][NUM_MONTHS];

    // Constructor receives the names and the sales from the main method
    public Product(String[] names, int[][] salesData) {
        productNames = names;
        sales = salesData;
    }

    // Adds the three months of sales for one product
    private int getProductTotal(int productNumber) {
        int total = 0;

        for (int month = 0; month < NUM_MONTHS; month++) {
            total = total + sales[productNumber][month];
        }
        return total;
    }

    // Adds the totals of all the products together
    public int GetTotalProductsSold() {
        int allProducts = 0;

        for (int product = 0; product < NUM_PRODUCTS; product++) {
            allProducts = allProducts + getProductTotal(product);
        }
        return allProducts;
    }

    // Average = total sales divided by the number of values (3 x 3 = 9)
    // The total is changed to a double so the decimals are not lost
    public double GetAverageProductSold() {
        double average = (double) GetTotalProductsSold() / (NUM_PRODUCTS * NUM_MONTHS);
        return average;
    }

    // Finds the product with the highest total sales
    public String GetMostPopularProduct() {
        int highestTotal = getProductTotal(0);
        String popularProduct = productNames[0];

        // Start at 1 because product 0 is already stored as the highest
        for (int product = 1; product < NUM_PRODUCTS; product++) {
            if (getProductTotal(product) > highestTotal) {
                highestTotal = getProductTotal(product);
                popularProduct = productNames[product];
            }
        }
        return popularProduct + " (" + highestTotal + ")";
    }
}
