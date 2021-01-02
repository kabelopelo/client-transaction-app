package com.client.transaction.webapi.services;

import com.client.transaction.webapi.dtos.TransactionDto;
import com.client.transaction.webapi.exceptions.ValidationException;

public interface TransactionValidationService {
    public void validateTransaction(TransactionDto transaction) throws ValidationException;

}
