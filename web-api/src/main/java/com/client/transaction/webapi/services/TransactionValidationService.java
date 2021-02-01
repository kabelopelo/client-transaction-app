package com.client.transaction.webapi.services;

import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Transaction;

public interface TransactionValidationService {
    public void validateTransaction(Transaction transaction) throws ValidationException;

}
