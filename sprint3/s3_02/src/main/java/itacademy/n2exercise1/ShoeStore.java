package itacademy.n2exercise1;

public class ShoeStore {
    private final PaymentGateway paymentGateway;

    public ShoeStore() {
        this.paymentGateway = new PaymentGateway();
    }

    public void checkout(PaymentMethod paymentMethod) {
        paymentGateway.processPayment(paymentMethod, new PaymentCallback() {
            @Override
            public void onPaymentSuccess(String message) {
                System.out.println("ShoeStore: " + message);
            }

            @Override
            public void onPaymentFailure(String error) {
                System.out.println("ShoeStore: " + error);
            }
        });
    }

    public static void main(String[] args) {
        ShoeStore store = new ShoeStore();

        PaymentMethod creditCardPayment = new CreditCardPayment();
        store.checkout(creditCardPayment);

        PaymentMethod paypalPayment = new PaypalPayment();
        store.checkout(paypalPayment);

        PaymentMethod bankAccountPayment = new BankAccountPayment();
        store.checkout(bankAccountPayment);
    }
}
