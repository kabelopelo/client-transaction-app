package com.client.transaction.webapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto extends BaseDto {

    private int clientId;
    private Double transactionsAmount;

    public TransactionDto() {
    }

    public TransactionDto(int clientId, Double transactionsAmount) {
        this.clientId = clientId;
        this.transactionsAmount = transactionsAmount;
    }
}
