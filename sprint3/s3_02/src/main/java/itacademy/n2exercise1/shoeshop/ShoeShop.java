package itacademy.n2exercise1.shoeshop;

import itacademy.n2exercise1.payment.*;

import java.util.ArrayList;
import java.util.List;

public class ShoeShop {
    private final List<Shoe> stock = new ArrayList<>();
    private final List<Shoe> basket = new ArrayList<>();
    private final PaymentGateway paymentGateway = new PaymentGateway();

    public List<Shoe> getStock() {
        return stock;
    }

    public List<Shoe> getBasket() {
        return basket;
    }

    public void addShoe(Shoe shoe) {
        stock.add(shoe);
    }

    public void buyShoes(PaymentMethod paymentMethod, double totalAmount) {
        System.out.println("Executing payment...");
        String result = paymentGateway.executePayment(paymentMethod, totalAmount);
        System.out.println(result);
        basket.clear(); // Limpar o carrinho após o pagamento ser executado com sucesso
    }

    public double calculateTotal() {
        double total = 0;
        for (Shoe shoe : basket) {
            total += shoe.getPrice();
        }
        return total;
    }
}


