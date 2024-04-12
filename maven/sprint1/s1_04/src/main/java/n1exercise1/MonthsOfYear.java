package n1exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonthsOfYear {
    public static List<String> createMonthsList() {
        return new ArrayList<>(Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"));
    }
}
