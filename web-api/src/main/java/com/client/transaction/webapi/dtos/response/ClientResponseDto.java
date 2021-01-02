package com.client.transaction.webapi.dtos.response;

import com.client.transaction.webapi.dtos.ClientDto;
import com.client.transaction.webapi.enums.RequestStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDto extends ResponseDto {

    ClientDto clientDto;

    public ClientResponseDto() {
    }

    public ClientResponseDto(RequestStatusEnum requestStatusEnum, String notes) {
        super(requestStatusEnum, notes);
    }
}
