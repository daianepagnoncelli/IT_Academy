import n1exercise2.DniCalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DniCalculatorTest {

    @Test
    public void testCalculateDniLetter() {
        // Test with some predefined DNI numbers
        assertEquals('Q', DniCalculator.calculateDniLetter(51590695));
        assertEquals('P', DniCalculator.calculateDniLetter(40050483));
        assertEquals('H', DniCalculator.calculateDniLetter(9242016));
        assertEquals('L', DniCalculator.calculateDniLetter(29824096));
        assertEquals('K', DniCalculator.calculateDniLetter(3086736));
        // Add more test cases as needed
    }
}