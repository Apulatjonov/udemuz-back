package com.api.udemuz.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 04:07
 */

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidMailException(InvalidEmailException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionResponse(exception.getField(), exception.getMessage(), exception.getStatus()));
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidPasswordException(InvalidPasswordException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionResponse(exception.getField(), exception.getMessage(), exception.getStatus()));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionResponse(exception.getField(), exception.getMessage(), exception.getStatus())
        );
    }

    @ExceptionHandler(NotVerifiedAccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> notVerifiedAccountExceptionHandler(NotVerifiedAccountException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionResponse(exception.getField(), exception.getMessage(), exception.getStatus())
        );
    }

    @ExceptionHandler(UserAlreadyVerifiedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> userAlreadyVerifiedExceptionHandler(UserAlreadyVerifiedException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionResponse(exception.getField(), exception.getMessage(), exception.getStatus())
        );
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponse> badRequestExceptionHandler(BadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionResponse(exception.getField(), exception.getMessage(), exception.getStatus())
        );
    }
}
