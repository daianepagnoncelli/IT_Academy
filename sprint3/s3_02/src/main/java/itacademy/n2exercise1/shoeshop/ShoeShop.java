package itacademy.n2exercise1.shoeshop;

import itacademy.n2exercise1.payment.*;

import java.util.ArrayList;
import java.util.List;

public class ShoeShop {
    private final List<Shoe> stock = new ArrayList<>();
    private final PaymentGateway paymentGateway = new PaymentGateway();

    public List<Shoe> getStock() {
        return stock;
    }

    public void addShoe(Shoe shoe) {
        stock.add(shoe);
    }

    public String buyShoes(PaymentMethod paymentMethod, double totalAmount) {
        return paymentGateway.executePayment(paymentMethod, totalAmount);
    }
}



