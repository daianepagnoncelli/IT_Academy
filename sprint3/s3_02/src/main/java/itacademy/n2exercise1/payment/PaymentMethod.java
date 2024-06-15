package itacademy.n2exercise1.payment;

public interface PaymentMethod {

    String successfulPayment(double totalAmount);

    String paymentCancelled(double totalAmount);
}

