package n2exercise1.address;

public class BRAddress implements IAddress {
    private String street;
    private String streetNumber;
    private String floorNumber;
    private String doorNumber;
    private String cityTown;
    private String province;
    private String postCode;

    public BRAddress(String street, String streetNumber, String floorNumber, String doorNumber, String cityTown, String province, String postCode) {
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
        addressString.append("Endereço   |    ").append(street).append(", ").append(streetNumber);
        if (!floorNumber.isEmpty()) addressString.append(", ").append(floorNumber);
        if (!doorNumber.isEmpty()) addressString.append(", ").append(doorNumber);
        addressString.append(", ").append(cityTown).append(", ").append(province).append(", ").append(postCode).append("\n");
        return addressString.toString();
    }
}

