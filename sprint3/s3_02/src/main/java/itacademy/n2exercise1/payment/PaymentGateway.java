package itacademy.n2exercise1.payment;

import java.util.Random;

public class PaymentGateway {

    public String executePayment(PaymentMethod paymentMethod, double totalAmount) {
        System.out.println("Executing payment...");
        return (new Random().nextBoolean()) ?
                paymentMethod.successfulPayment(totalAmount) :
                paymentMethod.paymentCancelled(totalAmount);
    }
}

