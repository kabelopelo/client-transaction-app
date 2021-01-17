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
public class Transaction {

    @Id
    private String _id;
    private String _clientId;
    private Double transactionsAmount;

    public Transaction() {
    }

    public Transaction(String _id, String _clientId, double transactionsAmount) {
        this._id = _id;
        this._clientId = _clientId;
        this.transactionsAmount = transactionsAmount;
    }
}
