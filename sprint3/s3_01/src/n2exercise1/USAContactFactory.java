package n2exercise1;

public class USAContactFactory implements ContactFactory {
    @Override
    public PhoneNumber createPhoneNumber(String phoneNumber) {
        return new USAPhoneNumber(phoneNumber);
    }

    @Override
    public Address createAddress(String street, String city, String postalCode) {
        return new USAAddress(street, city, postalCode);
    }
}
