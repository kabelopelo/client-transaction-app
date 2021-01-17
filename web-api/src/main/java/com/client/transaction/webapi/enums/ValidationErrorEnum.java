package com.client.transaction.webapi.enums;

public enum ValidationErrorEnum {

    MISSING_REQUIRED_ELEMENT_NAME("Name is mandatory"),
    MISSING_REQUIRED_ELEMENT_SURNAME("Surname is mandatory"),
    MISSING_REQUIRED_ELEMENT_ID("ID number is mandatory"),
    MISSING_REQUIRED_ELEMENT_MOBILE_NUMBER("Mobile number is mandatory"),
    MISSING_REQUIRED_ELEMENT_TRANSACTION("Transaction is mandatory"),

    INVALID_CELL_NUMBER("Invalid phone number entered."),
    INVALID_CLIENT_NAME("Invalid (sur)name entered. (Sur)name must not be null and should have min 3 characters."),
    INVALID_ID_NUMBER("Invalid phone number entered."),
    INVALID_AMOUNT("Invalid amount entered.");

    private String message;

    ValidationErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
