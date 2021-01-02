package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.dtos.ClientDto;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.services.ClientValidationService;
import org.springframework.stereotype.Component;

@Component
public class ClientValidationServiceImpl implements ClientValidationService {

    public void validateClient(ClientDto clientDto) throws ValidationException {

        this.validateMandatoryClientDetails(clientDto);
        this.validateClientName(clientDto);
        this.validateClientMobileNumber(clientDto.getMobileNumber());
        this.validateDuplicateClientCellphoneNumber(clientDto.getMobileNumber());
        this.validateClientIdNumber(clientDto.getIdNumber());
        this.validateDuplicateClientIdNumber(clientDto.getIdNumber());
    }

    @Override
    public void validateMandatoryClientDetails(ClientDto clientDto) {

    }

    @Override
    public void validateClientMobileNumber(String cellphoneNumber) {

    }

    @Override
    public void validateDuplicateClientCellphoneNumber(String cellphoneNumber) {

    }

    @Override
    public void validateClientIdNumber(String IdNumber) {

    }

    @Override
    public void validateDuplicateClientIdNumber(String IdNumber) {

    }

    @Override
    public void validateClientName(ClientDto clientDto) {
    }
}
