package itacademy.n2exercise1;

import java.util.Random;

public class BankAccountPayment implements PaymentMethod {
    @Override
    public void pay(PaymentCallback callback) {
        boolean success = new Random().nextBoolean();

        if (success) {
            callback.onPaymentSuccess("Payment made successfully with Bank Account.");
        } else {
            callback.onPaymentFailure("Bank Account payment failed.");
        }
    }
}

