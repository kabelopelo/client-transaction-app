package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.enums.ValidationErrorEnum;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Transaction;
import com.client.transaction.webapi.services.TransactionValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionValidationServiceImplTest {

    private TransactionValidationService transactionValidationService;
    public Transaction transaction;

    @BeforeEach
    public void init() {
        transactionValidationService = new TransactionValidationServiceImpl();
        transaction = new Transaction();
    }

    @Test
    public void TestNullTransactionAmount() {
        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            transactionValidationService.validateTransaction(transaction);
        });

        assertEquals(validationException.getMessage(), ValidationErrorEnum.MISSING_REQUIRED_ELEMENT_TRANSACTION.getMessage());
    }

    @Test
    public void TestZeroTransactionAmount() {
        transaction.setTransactionsAmount(new Double(0.0));

        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            transactionValidationService.validateTransaction(transaction);
        });

        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_AMOUNT.getMessage());
    }

    @Test
    public void TestNegativeTransactionAmount() {
        transaction.setTransactionsAmount(new Double(-5.0));

        ValidationException validationException = assertThrows(ValidationException.class, () -> {
            transactionValidationService.validateTransaction(transaction);
        });

        assertEquals(validationException.getMessage(), ValidationErrorEnum.INVALID_AMOUNT.getMessage());
    }

    @Test
    public void TestValidTransactionAmount() {
        transaction.setTransactionsAmount(new Double(10.50));

        assertDoesNotThrow(() -> {
            transactionValidationService.validateTransaction(transaction);
        });
    }
}
