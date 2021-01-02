package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.dtos.TransactionDto;
import com.client.transaction.webapi.dtos.response.TransactionResponseDto;
import com.client.transaction.webapi.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class.getName());

    @Override
    public TransactionResponseDto createTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public TransactionResponseDto updateTransactions(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public TransactionResponseDto deleteTransactions(int transactionId) {
        return null;
    }

    @Override
    public TransactionResponseDto getTransactions(int clientId) {
        return null;
    }
}
