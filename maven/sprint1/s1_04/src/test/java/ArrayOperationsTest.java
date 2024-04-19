import n1exercise3.ArrayOperations;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayOperationsTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayIndexOutOfBoundsException() {
        int[] testArray = {1, 2, 3, 4, 5};
        ArrayOperations arrayOperations = new ArrayOperations(testArray);
        arrayOperations.getElementAtIndex(10);
    }

    @Test
    public void testValidIndex() {
        int[] testArray = {1, 2, 3, 4, 5};
        ArrayOperations arrayOperations = new ArrayOperations(testArray);
        int result = arrayOperations.getElementAtIndex(2);
        assertEquals(3, result);
    }
}
