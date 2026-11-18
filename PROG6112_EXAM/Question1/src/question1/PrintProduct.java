package question1;

// This class only prints the report information
public class PrintProduct {

    // Created an Object that is used to get the report values
    private IProduct product;

    // Constructors receiving the Product object
    public PrintProduct(IProduct product) {
        this.product = product;
    }

    // Prints the total product sales
    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Prints the average product sales as a whole number
    public void PrintAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    // Prints the most popular product
    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
