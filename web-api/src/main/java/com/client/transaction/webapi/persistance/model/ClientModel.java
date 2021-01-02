package com.client.transaction.webapi.persistance.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Repository
@Document(collection = "client")
public class ClientModel {

    @Id
    public String _id;
    public String firstName;
    public String lastName;
    public String fullName;
    public String mobileNumber;
    public String idNumber;
    public String physicalAddress;

    public ClientModel() {
    }

    public ClientModel(String firstName, String lastName, String fullName, String mobileNumber, String idNumber, String physicalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.idNumber = idNumber;
        this.physicalAddress = physicalAddress;
    }
}
