package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.enums.ValidationErrorEnum;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientValidationServiceImplTest {

    private ClientValidationServiceImpl clientValidationService;
    public Client client;

    @BeforeEach
    public void init() {
        clientValidationService = new ClientValidationServiceImpl();
        client = new Client();
    }

    @Test
    public void TestValidateClientName() {
        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(client);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        client = new Client("M", "Jane", null, null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(client);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        client = new Client("Marry", "Ja", null, null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(client);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        client = new Client("Ma", "Ja", null, null, null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientName(client);
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CLIENT_NAME.getMessage());

        client = new Client("Mar", "Jan", null, null, null, null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientName(client);
        });

        client = new Client("Marry", "Jane", null, null, null, null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientName(client);
        });
    }

    @Test
    public void TestValidateMobileNumber() {
        client = new Client(null, null, null, "22222", null, null);
        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(client.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CELL_NUMBER.getMessage());

        client = new Client(null, null, null, "2222222222", null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(client.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CELL_NUMBER.getMessage());

        client = new Client(null, null, null, "0122222222", null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(client.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CELL_NUMBER.getMessage());

        client = new Client(null, null, null, "0722222", null, null);
        validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientMobileNumber(client.getMobileNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_CELL_NUMBER.getMessage());

        client = new Client(null, null, null, "0722222222", null, null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientMobileNumber(client.getMobileNumber());
        });
    }

    @Test
    public void TestValidateIDNumber() {
        client = new Client(null, null, null, null, "891111593308", null);
        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            clientValidationService.validateClientIdNumber(client.getIdNumber());
        });
        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_ID_NUMBER.getMessage());

        client = new Client(null, null, null, null, "8911115933087", null);
        assertDoesNotThrow(() -> {
            clientValidationService.validateClientIdNumber(client.getIdNumber());
        });
    }
}

