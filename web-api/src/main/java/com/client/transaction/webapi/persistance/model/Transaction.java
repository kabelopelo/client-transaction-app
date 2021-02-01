package com.client.transaction.webapi.persistance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Getter
@Setter
@Repository
@Document(collection = "transaction")
@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public class Transaction {

    @Id
    private String _id;
    private String _clientId;
    private Double transactionsAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", locale = "en_GB")
    private Date date;

    public Transaction() {
    }

    public Transaction(String _id, String _clientId, Double transactionsAmount, Date date) {
        this._id = _id;
        this._clientId = _clientId;
        this.transactionsAmount = transactionsAmount;
        this.date = date;
    }
}
