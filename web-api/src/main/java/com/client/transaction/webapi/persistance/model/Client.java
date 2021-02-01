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
public class Client {

    @Id
    private String _id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String mobileNumber;
    private String idNumber;
    private String physicalAddress;

    public Client() {
    }

    public Client(String firstName, String lastName, String fullName, String mobileNumber, String idNumber, String physicalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.idNumber = idNumber;
        this.physicalAddress = physicalAddress;
    }
}
