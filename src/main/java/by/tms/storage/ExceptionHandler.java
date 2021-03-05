package by.tms.storage;

import by.tms.model.User;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> map = new HashMap<>();
        for (FieldError fieldError: ex.getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
//    @RestControllerAdvice
//    public class ExceptionHandler{
//
//        @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
//        public ResponseEntity<Object> userNotFound(UserNotFoundException ex){
//            return new ResponseEntity<>(ex.getMessage());
//        }
//}
