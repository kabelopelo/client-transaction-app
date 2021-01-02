package com.client.transaction.webapi.exceptions;


import com.client.transaction.webapi.enums.ValidationErrorEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends Throwable {

    private String message;
    private ValidationErrorEnum validationErrorEnum;

    public ValidationException(ValidationErrorEnum validationErrorEnum) {
        super(validationErrorEnum.getMessage());
        this.message = validationErrorEnum.getMessage();
        this.validationErrorEnum = validationErrorEnum;
    }
}