package n2exercise1.USA;

import n2exercise1.Address;
import n2exercise1.ContactFactory;
import n2exercise1.PhoneNumber;

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
