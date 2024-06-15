package itacademy.n2exercise1.payment;

public class PayPalPayment implements PaymentMethod {
    private String accountName;

    public PayPalPayment(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String successfulPayment(double totalAmount) {
        return "The payment of " + totalAmount + " € has been completed via PayPal account: " + accountName;
    }

    @Override
    public String paymentCancelled(double totalAmount) {
        return "Payment cancelled for PayPal account: " + accountName;
    }
}


