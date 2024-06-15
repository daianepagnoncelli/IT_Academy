package n2exercise1;

import java.util.Arrays;
import java.util.Optional;

public enum Country {
    SPAIN("Spain", "^[0-9]{5}$", "^[0-9]{9}$"),
    BRAZIL("Brazil", "^[0-9]{5}-[0-9]{3}$", "^\\([0-9]{2}\\)\\s[0-9]{4,5}-[0-9]{4}$");

    private final String name;
    private final String regexPostCode;
    private final String regexPhoneNumber;

    Country(String name, String regexPostCode, String regexPhoneNumber) {
        this.name = name;
        this.regexPostCode = regexPostCode;
        this.regexPhoneNumber = regexPhoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getRegexPostCode() {
        return regexPostCode;
    }

    public String getRegexPhoneNumber() {
        return regexPhoneNumber;
    }

    public static Optional<Country> findByValue(String value) {
        return Arrays.stream(values())
                .filter(country -> country.name.equalsIgnoreCase(value))
                .findFirst();
    }
}