package cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<String> handleFruitNotFoundException(FruitNotFoundException e, WebRequest request) {
        String message = e.getMessage() + " " + request.getDescription(false);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FruitAlreadyExistsException.class)
    public ResponseEntity<String> handleFruitAlreadyExistsException(FruitAlreadyExistsException e, WebRequest request) {
        String message = e.getMessage() + " " + request.getDescription(false);
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }
}
