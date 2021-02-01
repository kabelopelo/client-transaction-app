package com.client.transaction.webapi.controllers;

import com.client.transaction.webapi.dtos.response.TransactionResponseDto;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Transaction;
import com.client.transaction.webapi.services.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class.getName());


    @PostMapping("/create-transaction")
    @ApiOperation(value = "Create a new transaction",
            notes = "Create a new transaction with the argument transactionDto",
            response = TransactionResponseDto.class)
    public TransactionResponseDto createTransaction(@RequestBody Transaction transaction) throws ValidationException {
        LOGGER.info("Creating transaction with id: {}", transaction.get_id());

        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/get-transaction/{id}")
    @ApiOperation(value = "Get transaction",
            notes = "Get transaction of argument id",
            response = TransactionResponseDto.class)
    public Optional<Transaction> getTransaction(@RequestBody Transaction transactionDto) {
        LOGGER.info("Retrieving transaction with id: {}", transactionDto.get_id(), transactionDto.get_id());

        return transactionService.getTransactionById(transactionDto.get_id());
    }

    @GetMapping("/get-all-transactions/{id}")
    @ApiOperation(value = "Get transaction",
            notes = "Get transaction of argument id",
            response = TransactionResponseDto.class)
    public List<Transaction> getTransactions(@PathVariable String id) {
        LOGGER.info("Retrieving all transactions");

        return transactionService.getAllTransactions(id);
    }

    @PutMapping("/update-transaction")
    public TransactionResponseDto updateTransaction(@RequestBody Transaction transaction) throws ValidationException {
        LOGGER.info("Updating transaction with id and name: {}", transaction.get_id(), transaction.get_id());

        return transactionService.updateTransactions(transaction);
    }

    @DeleteMapping("/delete-transaction/{transactionId}")
    public TransactionResponseDto updateTransaction(@PathVariable String transactionId) {
        LOGGER.info("Deleting transaction with id : {}", transactionId);

        return transactionService.deleteTransactions(transactionId);
    }


}
