package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.enums.ValidationErrorEnum;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Transaction;
import com.client.transaction.webapi.services.TransactionValidationService;
import org.springframework.stereotype.Service;

@Service
public class TransactionValidationServiceImpl implements TransactionValidationService {

    public void validateTransaction(Transaction transaction) throws ValidationException {
        this.validateNullTransactionAmount(transaction);
        this.validateInvalidTransactionAmount(transaction);
    }

    public void validateNullTransactionAmount(Transaction transaction) throws ValidationException {
        if (transaction.getTransactionsAmount() == null) {
            throw new ValidationException(ValidationErrorEnum.MISSING_REQUIRED_ELEMENT_TRANSACTION);
        }
    }

    public void validateInvalidTransactionAmount(Transaction transaction) throws ValidationException {
        if (transaction.getTransactionsAmount() <= 0) {
            throw new ValidationException(ValidationErrorEnum.INVALID_AMOUNT);
        }
    }
}
