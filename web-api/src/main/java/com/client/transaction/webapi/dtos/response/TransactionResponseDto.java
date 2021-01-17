package com.client.transaction.webapi.dtos.response;

import com.client.transaction.webapi.enums.RequestStatusEnum;
import com.client.transaction.webapi.persistance.model.Transaction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponseDto extends ResponseDto {

    Transaction transaction;

    public TransactionResponseDto() {
    }

    public TransactionResponseDto(RequestStatusEnum requestStatusEnum, String notes) {
        super(requestStatusEnum, notes);
    }
}
