package com.kodcu.javaday.exception.error;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldValidationError {
    String message;
    String field;
    String value;
}
