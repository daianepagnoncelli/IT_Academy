package n2exercise1;

public interface ContactFactory {
    PhoneNumber createPhoneNumber(String phoneNumber);
    Address createAddress(String street, String city, String postalCode);
}

