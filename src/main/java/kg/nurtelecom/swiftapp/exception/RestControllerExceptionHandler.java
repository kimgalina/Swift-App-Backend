package kg.nurtelecom.swiftapp.exception;

import kg.nurtelecom.swiftapp.util.ResponseMessage;
import kg.nurtelecom.swiftapp.util.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
        List<String> errors = new ArrayList<>();
        for(ObjectError error : exc.getAllErrors()) {
            errors.add(error.getDefaultMessage());
        }
        return new ResponseMessage<>(errors, ResultCode.FAIL);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage<?> handleException(Exception e) {
        return new ResponseMessage<>(
                e.getMessage(),
                ResultCode.EXCEPTION
        );
    }


}
