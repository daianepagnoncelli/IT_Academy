package itacademy.n2exercise1;

public class PaymentGateway {
    public void processPayment(PaymentMethod paymentMethod, PaymentCallback callback) {
        paymentMethod.pay(callback);
    }
}
