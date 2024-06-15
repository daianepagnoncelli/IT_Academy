package n2exercise1.address;

public class ESAddress implements IAddress {
    private final String street;
    private final String streetNumber;
    private final String floorNumber;
    private final String doorNumber;
    private final String cityTown;
    private final String province;
    private final String postCode;

    public ESAddress(String street, String streetNumber, String floorNumber, String doorNumber, String cityTown, String province, String postCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.floorNumber = floorNumber;
        this.doorNumber = doorNumber;
        this.cityTown = cityTown;
        this.province = province;
        this.postCode = postCode;
    }

    @Override
    public String showAddress() {
        StringBuilder addressString = new StringBuilder();
        addressString.append("Address     |    ").append(street).append(", ").append(streetNumber);
        if (!floorNumber.isEmpty()) addressString.append(", ").append(floorNumber);
        if (!doorNumber.isEmpty()) addressString.append(", ").append(doorNumber);
        addressString.append(", ").append(cityTown).append(", ").append(province).append(", ").append(postCode).append("\n");
        return addressString.toString();
    }
}

