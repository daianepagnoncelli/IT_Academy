import n1exercise2.DniCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DniCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {12345678, 87654321, 98765432, 34567890, 56789012, 90123456, 65432109, 21098765, 43210987, 89012345})
    public void testDniCalculator(int dniNumber) {
        DniCalculator dniCalculator = new DniCalculator();
        char expectedLetter = getExpectedLetter(dniNumber);
        assertEquals(expectedLetter, dniCalculator.calculateDniLetter(dniNumber));
    }

    private char getExpectedLetter(int dniNumber) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.charAt(dniNumber % 23);
    }
}






