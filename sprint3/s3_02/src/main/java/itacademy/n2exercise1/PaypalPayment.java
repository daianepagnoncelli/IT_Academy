package itacademy.n2exercise1;

import java.util.Random;

public class PaypalPayment implements PaymentMethod {
    @Override
    public void pay(PaymentCallback callback) {
        boolean success = new Random().nextBoolean();

        if (success) {
            callback.onPaymentSuccess("Payment made successfully with PayPal.");
        } else {
            callback.onPaymentFailure("PayPal payment failed.");
        }
    }
}

