package n2exercise1;

import n2exercise1.address.IAddress;
import n2exercise1.phonenumber.IPhoneNumber;

public class Contact implements Comparable<Contact> {
    private final String name;
    private final String country;
    private final IPhoneNumber phoneNumber;
    private final IAddress address;

    public Contact(String name, String country, IAddress address, IPhoneNumber phoneNumber) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int compareTo(Contact o) {
        if (this.country.equalsIgnoreCase(o.getCountry())) {
            return this.name.compareTo(o.getName());
        } else {
            return this.country.compareTo(o.getCountry());
        }
    }

    @Override
    public String toString() {
        return (
                "------------------------------------------------------------------------------------\n" +
                        "Nome        |    " + this.name + "\n"
                        + this.address.showAddress()
                        + this.phoneNumber.showPhoneNumber() +
                        "------------------------------------------------------------------------------------");
    }
}
