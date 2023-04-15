package com.kodcu.javaday.exception.handler;

import com.kodcu.javaday.exception.error.FieldValidationError;
import com.kodcu.javaday.mapper.FieldValidationErrorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final FieldValidationErrorMapper fieldValidationErrorMapper;

    @ExceptionHandler(Exception.class)
    public void handleGlobalExceptions(Exception exception){
        exception.printStackTrace();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Set<FieldValidationError>> handleArgumentException(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors().stream()
                .map(fieldValidationErrorMapper::toFieldValidationErrorFromFieldError)
                .collect(Collectors.toSet());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}