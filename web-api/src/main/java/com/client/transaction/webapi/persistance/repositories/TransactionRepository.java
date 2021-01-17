package com.client.transaction.webapi.persistance.repositories;

import com.client.transaction.webapi.persistance.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
