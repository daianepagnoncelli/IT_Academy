package n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Product> products;
    private double totalSalePrice;

    public Sale() {
        this.products = new ArrayList<>();
        this.totalSalePrice = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() throws SaleEmptyException {
        if (products.isEmpty()) {
            throw new SaleEmptyException("To make a sale you must first add products");
        } else {
            for (Product product : products) {
                totalSalePrice += product.getPrice();
            }
            return totalSalePrice;
        }
    }
}

