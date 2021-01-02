package com.client.transaction.webapi.services;

import com.client.transaction.webapi.dtos.TransactionDto;
import com.client.transaction.webapi.dtos.response.TransactionResponseDto;

public interface TransactionService {

    public TransactionResponseDto createTransaction(TransactionDto transactionDto);

    public TransactionResponseDto updateTransactions(TransactionDto transactionDto);

    public TransactionResponseDto deleteTransactions(int transactionId);

    public TransactionResponseDto getTransactions(int clientId);

}
