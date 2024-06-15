package n2exercise1.address;

public class BRAddress implements IAddress {

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
        if (!floorNumber.isEmpty()) addressString.append(", ").append(floorNumber);
        if (!doorNumber.isEmpty()) addressString.append(", ").append(doorNumber);
        addressString.append(", ").append(cityTown).append(", ").append(province).append(", ").append(postCode).append("\n");
        return addressString.toString();

    }
}

