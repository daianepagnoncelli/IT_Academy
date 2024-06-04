package n2exercise1.UK;

import n2exercise1.Address;

public class UKAddress implements Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public UKAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFormattedAddress() {
        return String.format("%s, %s %s", street, city, postalCode);
    }
}
