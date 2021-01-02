package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.dtos.ClientDto;
import com.client.transaction.webapi.enums.ValidationErrorEnum;
import com.client.transaction.webapi.exceptions.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientValidationServiceImplTest {

    private ClientValidationServiceImpl clientValidationService;
    public ClientDto clientDto;

    @BeforeEach
    public void init() {
        clientValidationService = new ClientValidationServiceImpl();
        clientDto = new ClientDto();
    }

    @Test
    public void TestValidateMandatoryClientDetails() {

        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateMandatoryClientDetails(clientDto);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.MISSING_REQUIRED_ELEMENT_NAME.getMessage());

        clientDto = new ClientDto("Marry", null, null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateMandatoryClientDetails(clientDto);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.MISSING_REQUIRED_ELEMENT_NAME.getMessage());

        clientDto = new ClientDto("Marry", "Jane", null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateMandatoryClientDetails(clientDto);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.MISSING_REQUIRED_ELEMENT_ID.getMessage());

        clientDto = new ClientDto("Marry", "Jane", null, "8911115933087", null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateMandatoryClientDetails(clientDto);
        });

    }

    @Test
    public void TestValidateClientName() {
        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(clientDto);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        clientDto = new ClientDto("M", "Jane", null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(clientDto);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        clientDto = new ClientDto("Marry", "Ja", null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(clientDto);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        clientDto = new ClientDto("Ma", "Ja", null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(clientDto);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        clientDto = new ClientDto("Mar", "Jan", null, null, null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientName(clientDto);
        });

        clientDto = new ClientDto("Marry", "Jane", null, null, null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientName(clientDto);
        });
    }

    @Test
    public void TestValidateMobileNumber() {
        clientDto = new ClientDto(null, null, "22222", null, null);
        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(clientDto.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_PHONE_NUMBER.getMessage());

        clientDto = new ClientDto(null, null, "2222222222", null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(clientDto.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_PHONE_NUMBER.getMessage());

        clientDto = new ClientDto(null, null, "0122222222", null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(clientDto.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_PHONE_NUMBER.getMessage());

        clientDto = new ClientDto(null, null, "0722222", null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(clientDto.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_PHONE_NUMBER.getMessage());

        clientDto = new ClientDto(null, null, "0722222222", null, null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientMobileNumber(clientDto.getMobileNumber());
        });
    }

    @Test
    public void TestValidateIDNumber() {
        clientDto = new ClientDto(null, null, null, "891111593308", null);
        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientIdNumber(clientDto.getIdNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_ID_NUMBER.getMessage());

        clientDto = new ClientDto(null, null, null, "8911115933087", null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientIdNumber(clientDto.getIdNumber());
        });
    }
}

