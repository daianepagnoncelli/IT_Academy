package n2exercise1;

import java.util.Optional;
import java.util.stream.Stream;

public enum Country {
    SPAIN("Spain", "\\d{5}", "\\+34\\d{9}"), //PostCode: 28013 PhoneNumber:+34987654321
    BRAZIL("Brazil", "\\d{5}-\\d{3}", "\\+55\\d{11}"); //PostCode: 12345-678 PhoneNumber:+5511987654321

    private final String name;
    private final String regexPostCode;
    private final String regexPhoneNumber;

    Country(String name, String regexPostCode, String regexPhoneNumber) {
        this.name = name;
        this.regexPostCode = regexPostCode;
        this.regexPhoneNumber = regexPhoneNumber;
    }

    public String getRegexPostCode() {
        return regexPostCode;
    }

    public String getRegexPhoneNumber() {
        return regexPhoneNumber;
    }

    public static Optional<Country> findByValue(String value) {
        return Stream.of(values())
                .filter(country -> country.name.equalsIgnoreCase(value))
                .findFirst();

    }
}

