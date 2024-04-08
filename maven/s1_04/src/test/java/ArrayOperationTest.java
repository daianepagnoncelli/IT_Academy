import n1exercise3.ArrayOperation;
import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class ArrayOperationTest {
    @Test
    public void testArrayIndexException() {
        // Verify that the expected exception is thrown
        assertThrows(ArrayIndexOutOfBoundsException.class, ArrayOperation::throwArrayIndexException);
    }


}
