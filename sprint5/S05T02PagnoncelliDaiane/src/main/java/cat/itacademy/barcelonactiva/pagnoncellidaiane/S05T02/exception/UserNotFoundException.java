package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
