package n1exercise1;

import java.io.Serial;

public class SaleEmptyException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public SaleEmptyException(String message) {
        super(message);
    }
}
