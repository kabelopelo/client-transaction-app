package com.client.transaction.webapi.services;

import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Client;

public interface ClientValidationService {

    public void validateClientName(Client client) throws ValidationException;

    public void validateClientMobileNumber(String cellphoneNumber) throws ValidationException;

    public void validateClientIdNumber(String IdNumber) throws ValidationException;

    public void validateDuplicateClientCellphoneNumber(String cellphoneNumber);

    public void validateDuplicateClientIdNumber(String IdNumber);
}
