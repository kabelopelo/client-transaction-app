package com.client.transaction.webapi.persistance.model;

import com.client.transaction.webapi.utils.CustomDateDeserializer;
import com.client.transaction.webapi.utils.JsonDateDeserializer;
import com.client.transaction.webapi.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Repository
@Document(collection = "transaction")
public class Transaction implements Serializable {

    @Id
    private String _id;
    private String _clientId;
    private Double transactionsAmount;
    //    @JsonSerialize(using= JsonDateSerializer.class)
//    @JsonDeserialize(using= JsonDateDeserializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private LocalDateTime date;

    public Transaction() {
    }

    public Transaction(String _id, String _clientId, Double transactionsAmount, LocalDateTime date) {
        this._id = _id;
        this._clientId = _clientId;
        this.transactionsAmount = transactionsAmount;
        this.date = date;
    }
}
