package question1;

import java.util.Scanner;

// Main class
public class Question1 {

    public static void main(String[] args) {
        final int NUM_PRODUCTS = 3;
        final int NUM_MONTHS = 3;

        Scanner input = new Scanner(System.in);

        // Single array for the product names
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};

        // Two-dimensional array for the sales
        int[][] sales = new int[NUM_PRODUCTS][NUM_MONTHS];

        // Nested loops to ask for the sales of each product and each month
        for (int product = 0; product < NUM_PRODUCTS; product++) {
            for (int month = 0; month < NUM_MONTHS; month++) {
                System.out.print("Enter number of sales for month " + (month + 1)
                        + " for " + productNames[product] + " mattress: ");
                sales[product][month] = input.nextInt();
            }
            System.out.println();
        }

        // Create the objects
        Product mattresses = new Product(productNames, sales);
        PrintProduct report = new PrintProduct(mattresses);

        // Displaying the report
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        report.PrintTotalProductSales();
        report.PrintAverageProductSales();
        report.PrintMostPopularProduct();
    }
}
