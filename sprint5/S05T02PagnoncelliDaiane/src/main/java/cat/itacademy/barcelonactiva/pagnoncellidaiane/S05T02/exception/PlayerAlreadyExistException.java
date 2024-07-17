package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.exception;

public class PlayerAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PlayerAlreadyExistException(String msg) {
        super(msg);
    }
}

