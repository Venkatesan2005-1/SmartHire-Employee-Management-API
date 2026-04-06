package com.venkatesan.smarthire.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
    ErrorResponse error= new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            LocalDateTime.now()
    );
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
        String errorMessage=ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error->error.getField()+ ": "+error.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");
        ErrorResponse error=new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                errorMessage,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorResponse> handleGenericException(Exception ex){
    ErrorResponse error=new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Something went wrong: "+ ex.getMessage(),
            LocalDateTime.now()
    );
    return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
}

}