package com.client.transaction.webapi.services;

import com.client.transaction.webapi.dtos.response.TransactionResponseDto;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    TransactionResponseDto createTransaction(Transaction transaction) throws ValidationException;

    public TransactionResponseDto updateTransactions(Transaction transactionDto) throws ValidationException;

    public TransactionResponseDto deleteTransactions(String transactionId);

    public Optional<Transaction> getTransactionById(String transactionId);

    public List<Transaction> getAllTransactions();

}
