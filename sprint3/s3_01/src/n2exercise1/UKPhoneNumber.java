package n2exercise1;

public class UKPhoneNumber implements PhoneNumber {
    private final String phoneNumber;

    public UKPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getFormattedPhoneNumber() {
        return String.format("+44 %s %s %s", phoneNumber.substring(0, 2), phoneNumber.substring(2, 6), phoneNumber.substring(6));   // +44 20 1234 5678
    }
}



