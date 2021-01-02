package com.client.transaction.webapi.persistance.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Repository
@Document(collection = "transaction")
public class TransactionModel {

    @Id
    public int clientId;
    public double transactionsAmount;

    public TransactionModel() {
    }

    public TransactionModel(int clientId, double transactionsAmount) {
        this.clientId = clientId;
        this.transactionsAmount = transactionsAmount;
    }
}
