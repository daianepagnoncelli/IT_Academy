package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}

