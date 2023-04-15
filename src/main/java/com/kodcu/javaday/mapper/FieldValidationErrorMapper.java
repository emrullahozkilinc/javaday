package com.kodcu.javaday.mapper;

import com.kodcu.javaday.exception.error.FieldValidationError;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.validation.FieldError;

@Mapper(implementationName = "FieldValidationErrorMapperImpl" , componentModel = "spring")
public interface FieldValidationErrorMapper {

    @Mapping(target = "value", expression = "java(fieldError.getRejectedValue().toString())")
    @Mapping(target = "message", expression = "java(fieldError.getDefaultMessage())")
    FieldValidationError toFieldValidationErrorFromFieldError(FieldError fieldError);
}
