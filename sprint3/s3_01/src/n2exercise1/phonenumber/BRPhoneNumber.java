package n2exercise1.phonenumber;

public class BRPhoneNumber implements IPhoneNumber {
    private final String PREFIX = "(+55)";
    private String phoneNumber;

    public BRPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.replaceAll("\\s+", "");

        if (this.phoneNumber.startsWith("+55")) {
            this.phoneNumber = this.phoneNumber.substring(3);
        }

        if (this.phoneNumber.length() != 11) {
            throw new IllegalArgumentException("Invalid phone number format for Brazil. Must have exactly 9 digits.");
        }
    }

    @Override
    public String showPhoneNumber() {
        StringBuilder formattedNumber = new StringBuilder(PREFIX);
        for (int i = 0; i < phoneNumber.length(); i += 2) {
            if (i > 0) {
                formattedNumber.append(" ");
            }
            formattedNumber.append(phoneNumber.substring(i, Math.min(i + 4, phoneNumber.length())));
        }
        return "Telephone   |    " + formattedNumber.toString() + "\n";
    }
}


