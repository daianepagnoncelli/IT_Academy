package itacademy.n2exercise1.payment;

public class BankAccountPayment implements PaymentMethod {
    private String IBAN;

    public BankAccountPayment(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public String successfulPayment(double totalAmount) {
        return "The payment of " + totalAmount + " € has been deducted from account no. " + IBAN;
    }

    @Override
    public String paymentCancelled(double totalAmount) {
        return "Payment cancelled for account no. " + IBAN;
    }
}


