package n2exercise1.factory;

import n2exercise1.address.ESAddress;
import n2exercise1.address.IAddress;
import n2exercise1.phonenumber.ESPhoneNumber;
import n2exercise1.phonenumber.IPhoneNumber;

public class ESContactFactory implements IContactFactory {
    @Override
    public IAddress createAddress(String[] addressData) {
        if (addressData == null || addressData.length != 7) {
            throw new IllegalArgumentException("Invalid address data");
        }
        return new ESAddress(addressData[0], addressData[1], addressData[2], addressData[3], addressData[4], addressData[5], addressData[6]);
    }

    @Override
    public IPhoneNumber createPhoneNumber(String phoneNumber) {
        return new ESPhoneNumber(phoneNumber);
    }
}

