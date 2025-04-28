package org.example.securitydemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        final ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.NOT_FOUND)
                .build();

        return ResponseEntity
                .status(exceptionResponse.getStatus())
                .body(exceptionResponse);
    }

    @ExceptionHandler(ResourceAlreadyUsedException.class)
    public ResponseEntity<ExceptionResponse> handleResourceAlreadyUsedException(ResourceAlreadyUsedException e) {
        final ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.CONFLICT)
                .build();
        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        final ExceptionResponse exceptionResponse = this.getBadRequestResponseBuilder(ex.getBindingResult())
                .build();
        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }

    private ExceptionResponse.ExceptionResponseBuilder getBadRequestResponseBuilder(BindingResult result) {
        final String message = result.getFieldErrors().stream()
                .findFirst()
                .map(fieldError -> String.join(" ", StringUtils.capitalize(fieldError.getField()), fieldError.getDefaultMessage()))
                .orElse(null);
        return ExceptionResponse.builder()
                .withMessage(message)
                .withStatus(HttpStatus.BAD_REQUEST);
    }
}
