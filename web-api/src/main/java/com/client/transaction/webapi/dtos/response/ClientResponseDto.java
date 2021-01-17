package com.client.transaction.webapi.dtos.response;

import com.client.transaction.webapi.enums.RequestStatusEnum;
import com.client.transaction.webapi.persistance.model.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDto extends ResponseDto {

    Client client;

    public ClientResponseDto() {
    }

    public ClientResponseDto(RequestStatusEnum requestStatusEnum, String notes) {
        super(requestStatusEnum, notes);
    }
}
