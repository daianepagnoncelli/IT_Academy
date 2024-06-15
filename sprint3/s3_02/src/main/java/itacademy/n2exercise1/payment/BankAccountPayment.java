package itacademy.n2exercise1.payment;

public class BankAccountPayment implements PaymentMethod {

    private String IBAN;

    public BankAccountPayment(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public String successfulPayment(double totalAmount) {
        return "The payment of " + totalAmount + " € has been deducted from account no. " + this.IBAN;
    }

    @Override
    public String paymentCancelled(double totalAmount) {
        return "The bank account does not have enough funds.";
    }
}

