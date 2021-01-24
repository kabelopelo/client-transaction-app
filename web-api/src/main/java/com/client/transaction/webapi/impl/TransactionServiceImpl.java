package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.dtos.response.TransactionResponseDto;
import com.client.transaction.webapi.enums.RequestStatusEnum;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Transaction;
import com.client.transaction.webapi.persistance.repositories.TransactionRepository;
import com.client.transaction.webapi.services.TransactionService;
import com.client.transaction.webapi.services.TransactionValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionValidationService transactionValidationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class.getName());

    @Override
    public TransactionResponseDto createTransaction(Transaction transaction) throws ValidationException {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();

        transactionValidationService.validateTransaction(transaction);

        Transaction transactionResponse = transactionRepository.save(transaction);

        if (transactionResponse.get_id() != null) {
            transactionResponseDto.setRequestStatusEnum(RequestStatusEnum.SUCCESS);
            transactionResponseDto.setTransaction(transactionResponse);
        } else {
            transactionResponseDto.setRequestStatusEnum(RequestStatusEnum.FAILED);
            transactionResponseDto.setNotes("Transaction creation failed");
        }
        return transactionResponseDto;
    }

    @Override
    public TransactionResponseDto updateTransactions(Transaction transaction) throws ValidationException {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();

        transactionValidationService.validateTransaction(transaction);

        if (transactionRepository.existsById(transaction.get_id())) {
            transactionResponseDto.setTransaction(transactionRepository.save(transaction));
            transactionResponseDto.setRequestStatusEnum(RequestStatusEnum.SUCCESS);
        } else {
            transactionResponseDto.setRequestStatusEnum(RequestStatusEnum.FAILED);
            transactionResponseDto.setNotes("Client updating failed");
        }
        return transactionResponseDto;    }

    @Override
    public TransactionResponseDto deleteTransactions(String transactionId) {
        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();

        if (transactionRepository.existsById(transactionId)) {
            transactionRepository.deleteById(transactionId);
            transactionResponseDto.setRequestStatusEnum(RequestStatusEnum.SUCCESS);
        } else {
            transactionResponseDto.setRequestStatusEnum(RequestStatusEnum.FAILED);
            transactionResponseDto.setNotes("Client deletion failed");
        }
        return transactionResponseDto;    }

    @Override
    public Optional<Transaction> getTransactionById(String transactionId) {
        return transactionRepository.findById(transactionId);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

}
