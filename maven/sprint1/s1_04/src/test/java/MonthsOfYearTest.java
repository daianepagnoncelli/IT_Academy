import n1exercise1.MonthsOfYear;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MonthsOfYearTest {

    @Test
    public void testListSize() {
        // Arrange
        List<String> months = MonthsOfYear.createMonthsList();

        // Act & Assert
        assertEquals(12, months.size());
    }

    @Test
    public void testListNotNull() {
        // Arrange
        List<String> months = MonthsOfYear.createMonthsList();

        // Act & Assert
        assertNotNull(months);
    }

    @Test
    public void testAugustAtPositionEight() {
        // Arrange
        List<String> months = MonthsOfYear.createMonthsList();

        // Act & Assert
        assertEquals("August", months.get(7)); // Remember indices start from zero
    }

}
