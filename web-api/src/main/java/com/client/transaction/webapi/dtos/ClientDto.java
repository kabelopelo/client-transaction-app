package com.client.transaction.webapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto extends BaseDto {

    private String firstName;
    private String lastName;
    private String fullName;
    private String mobileNumber;
    private String idNumber;
    private String physicalAddress;

    public ClientDto() {
    }

    public ClientDto(String firstName, String lastName, String mobileNumber,
                     String idNumber, String physicalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.mobileNumber = mobileNumber;
        this.idNumber = idNumber;
        this.physicalAddress = physicalAddress;
    }
}

