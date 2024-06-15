package n2exercise1.factory;

import n2exercise1.address.BRAddress;
import n2exercise1.address.IAddress;
import n2exercise1.phonenumber.BRPhoneNumber;
import n2exercise1.phonenumber.IPhoneNumber;

public class BRContactFactory implements IContactFactory {
    @Override
    public IAddress createAddress(String[] addressData) {
        return new BRAddress(addressData[0], addressData[1], addressData[2], addressData[3], addressData[4], addressData[5], addressData[6]);
    }

    @Override
    public IPhoneNumber createPhoneNumber(String phoneNumber) {
        return new BRPhoneNumber(phoneNumber);
    }
}
