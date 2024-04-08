package n1exercise1;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonthsOfYearTest {
    private MonthsOfYear monthsOfYear;

    @BeforeEach
    public void setUp() {
        monthsOfYear = new MonthsOfYear();
    }

    @Test
    public void testCreateMonthsList() {
        List<String> expectedMonths = Arrays.asList("April", "August", "December", "February", "January", "July", "June", "March", "May", "November", "October", "September");
        List<String> actualMonths = monthsOfYear.createMonthsList();

        assertEquals(expectedMonths.size(), actualMonths.size());
        assertTrue(expectedMonths.containsAll(actualMonths) && actualMonths.containsAll(expectedMonths));
    }
}