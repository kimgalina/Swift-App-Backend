package kg.nurtelecom.swiftapp.exception;


import io.jsonwebtoken.ExpiredJwtException;
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


    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage<?> handleExpiredJwtException(ExpiredJwtException exc) {
        return new ResponseMessage<>(
                exc.getMessage(),
                ResultCode.EXCEPTION
        );
    }

    @ExceptionHandler(FileException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage<?> handleFileException(FileException exc) {
        return new ResponseMessage<>(
                exc.getMessage(),
                ResultCode.EXCEPTION
        );
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage<?> handleNotFoundException(NotFoundException exc) {
        return new ResponseMessage<>(
                exc.getMessage(),
                ResultCode.EXCEPTION
        );
    }
    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage<?> handleAlreadyExist(AlreadyExistException exc) {
        return new ResponseMessage<>(
                exc.getMessage(),
                ResultCode.EXCEPTION
        );
    }
    @ExceptionHandler(UserRegistrationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage<?> handleUserRegistrationException(UserRegistrationException exc) {
        return new ResponseMessage<>(
                exc.getMessage(),
                ResultCode.EXCEPTION
        );
    }

}
