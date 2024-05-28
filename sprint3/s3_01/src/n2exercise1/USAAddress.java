package n2exercise1;

public class USAAddress implements Address {
    private final String street;
    private final String city;
    private final String postalCode;

    public USAAddress(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    @Override
    public String getFormattedAddress() {
        return String.format("%s, %s, IL %s", street, city, postalCode);
    }
}

