package n2exercise1;

public class USAPhoneNumber implements PhoneNumber {
    private final String phoneNumber;

    public USAPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getFormattedPhoneNumber() {
        return String.format("(%s) %s-%s", phoneNumber.substring(0, 3), phoneNumber.substring(3, 6), phoneNumber.substring(6)); // (123) 456-7890
    }
}