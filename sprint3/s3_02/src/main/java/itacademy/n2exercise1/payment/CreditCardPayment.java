package itacademy.n2exercise1.payment;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String successfulPayment(double totalAmount) {
        return "The payment of " + totalAmount + " € has been charged to credit card no. " + cardNumber;
    }

    @Override
    public String paymentCancelled(double totalAmount) {
        return "Payment cancelled for credit card no. " + cardNumber;
    }
}

