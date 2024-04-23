package n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    public List<Product> products;
    private double totalSalePrice;

    public Sale() {
        products = new ArrayList<>();
        totalSalePrice = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void calculateTotal() throws SaleEmptyException {
        if (products.isEmpty()) {
            throw new SaleEmptyException("To make a sale you must first add products");
        }

        for (Product product : products) {
            totalSalePrice += product.price;
        }
    }

    public double getTotalSalePrice() {
        return totalSalePrice;
    }

  }
