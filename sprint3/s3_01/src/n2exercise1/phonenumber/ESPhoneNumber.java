package n2exercise1.phonenumber;

public class ESPhoneNumber implements IPhoneNumber {
    private final String PREFIX = "(+34)";
    private String phoneNumber;

    public ESPhoneNumber(String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String showPhoneNumber() {
        return ("Telefone   |    " + this.PREFIX + " " + this.phoneNumber + "\n");
    }
}
