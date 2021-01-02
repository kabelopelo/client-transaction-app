package com.client.transaction.webapi.dtos.response;

import com.client.transaction.webapi.dtos.TransactionDto;
import com.client.transaction.webapi.enums.RequestStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponseDto extends ResponseDto {

    TransactionDto transactionDto;

    public TransactionResponseDto() {
    }

    public TransactionResponseDto(RequestStatusEnum requestStatusEnum, String notes) {
        super(requestStatusEnum, notes);
    }
}
