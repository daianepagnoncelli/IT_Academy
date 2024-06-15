package itacademy.n2exercise1.payment;

public class PayPalPayment implements PaymentMethod {

    private String accountName;

    public PayPalPayment(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String successfulPayment(double totalAmount) {
        return "PayPal payment to account " + accountName + " of " + totalAmount + " € has been executed correctly.";
    }

    @Override
    public String paymentCancelled(double totalAmount) {
        return "There is something wrong with PayPal account " + accountName;
    }
}
