package itacademy.n2exercise1;

public interface PaymentCallback {
    void onPaymentSuccess(String message);
    void onPaymentFailure(String error);
}

