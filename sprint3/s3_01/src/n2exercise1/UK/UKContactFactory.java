package n2exercise1.UK;

import n2exercise1.*;

public class UKContactFactory implements ContactFactory {
    @Override
    public PhoneNumber createPhoneNumber(String phoneNumber) {
        return new UKPhoneNumber(phoneNumber);
    }

    @Override
    public Address createAddress(String street, String city, String postalCode) {
        return new UKAddress(street, city, postalCode);
    }
}

