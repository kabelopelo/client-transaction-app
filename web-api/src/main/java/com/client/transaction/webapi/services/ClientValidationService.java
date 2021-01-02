package com.client.transaction.webapi.services;

import com.client.transaction.webapi.dtos.ClientDto;

public interface ClientValidationService {

    public void validateMandatoryClientDetails(ClientDto clientDto);

    public void validateClientMobileNumber(String cellphoneNumber);

    public void validateDuplicateClientCellphoneNumber(String cellphoneNumber);

    public void validateClientIdNumber(String IdNumber);

    public void validateDuplicateClientIdNumber(String IdNumber);

    public void validateClientName(ClientDto clientDto);



}
