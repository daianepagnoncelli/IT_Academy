package n2exercise1.phonenumber;

public class BRPhoneNumber implements IPhoneNumber {
    private final String PREFIX = "(+55)";
    private String phoneNumber;

    public BRPhoneNumber(String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String showPhoneNumber() {
        return ("Telefone   |    " + this.PREFIX + " " + this.phoneNumber + "\n");
    }
}
