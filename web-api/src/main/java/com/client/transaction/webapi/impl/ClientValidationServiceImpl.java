package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.enums.ValidationErrorEnum;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Client;
import com.client.transaction.webapi.persistance.repositories.ClientRepository;
import com.client.transaction.webapi.services.ClientValidationService;
import com.client.transaction.webapi.utils.StringUtilsExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientValidationServiceImpl implements ClientValidationService {

    @Autowired
    private ClientRepository clientRepository;

    public void validateClient(Client client) throws ValidationException {
        this.validateClientName(client);
        this.validateClientMobileNumber(client.getMobileNumber());
        this.validateClientIdNumber(client.getIdNumber());
        this.isDuplicateClientCellphoneNumber(client.getMobileNumber());
        this.isDuplicateClientIdNumber(client.getIdNumber());
    }


    @Override
    public void validateClientName(Client client) throws ValidationException {
        if (!StringUtilsExt.hasMinNameLength(client.getFirstName(), 3)
                || !StringUtilsExt.hasMinNameLength(client.getLastName(), 3)) {
            throw new ValidationException(ValidationErrorEnum.INVALID_CLIENT_NAME);
        }
    }

    @Override
    public void validateClientMobileNumber(String cellphoneNumber) throws ValidationException {
        if (!StringUtilsExt.isValidCellphoneNumber(cellphoneNumber)) {
            throw new ValidationException(ValidationErrorEnum.INVALID_CELL_NUMBER);
        }
    }

    @Override
    public void validateClientIdNumber(String IdNumber) throws ValidationException {
        if (!StringUtilsExt.isValidIdentification(IdNumber)) {
            throw new ValidationException(ValidationErrorEnum.INVALID_ID_NUMBER);
        }
    }

    @Override
    public boolean isDuplicateClientCellphoneNumber(String cellphoneNumber) {
        Client client = clientRepository.findByMobileNumber(cellphoneNumber);
        return client == null ? false : true;
    }

    @Override
    public boolean isDuplicateClientIdNumber(String IdNumber) {
        Client client = clientRepository.findByIdNumber(IdNumber);
        return client == null ? false : true;
    }
}
