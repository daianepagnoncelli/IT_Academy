package itacademy.n2exercise1.payment;

public class CreditCardPayment implements PaymentMethod {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String successfulPayment(double totalAmount) {
        return "The payment of " + totalAmount + " €, has been charged to credit card no. " + cardNumber;
    }

    @Override
    public String paymentCancelled(double totalAmount) {
        return "Credit card no. " + cardNumber + " does not have enough credit.";
    }
}

