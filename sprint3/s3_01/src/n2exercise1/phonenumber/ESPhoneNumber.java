package n2exercise1.phonenumber;

public class ESPhoneNumber implements IPhoneNumber {
    private final String PREFIX = "(+34)";
    private String phoneNumber;

    public ESPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.replaceAll("\\s+", "");
     if (this.phoneNumber.startsWith("+34")) {
            this.phoneNumber = this.phoneNumber.substring(3);
        } else if (this.phoneNumber.startsWith("34")) {
            this.phoneNumber = this.phoneNumber.substring(2);
        }
    }

    @Override
    public String showPhoneNumber() {
        StringBuilder formattedNumber = new StringBuilder(PREFIX);
        for (int i = 0; i < phoneNumber.length(); i += 3) {
            if (i > 0) {
                formattedNumber.append(" ");
            }
            formattedNumber.append(phoneNumber.substring(i, Math.min(i + 3, phoneNumber.length())));
        }
        return "Telephone   |    " + formattedNumber.toString() + "\n";
    }
}
