package com.client.transaction.webapi.services;

import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Client;

public interface ClientValidationService {

    public void validateClient(Client client) throws ValidationException;

    public void validateClientName(Client client) throws ValidationException;

    public void validateClientMobileNumber(String cellphoneNumber) throws ValidationException;

    public void validateClientIdNumber(String IdNumber) throws ValidationException;

    public boolean isDuplicateClientCellphoneNumber(String cellphoneNumber);

    public boolean isDuplicateClientIdNumber(String IdNumber);
}
