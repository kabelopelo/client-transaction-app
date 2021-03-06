package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.dtos.response.ClientResponseDto;
import com.client.transaction.webapi.dtos.response.ResponseDto;
import com.client.transaction.webapi.enums.RequestStatusEnum;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Client;
import com.client.transaction.webapi.persistance.repositories.ClientRepository;
import com.client.transaction.webapi.services.ClientService;
import com.client.transaction.webapi.services.ClientValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientValidationService clientValidationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class.getName());

    @Override
    public ClientResponseDto createClient(Client client) throws ValidationException {
        ClientResponseDto clientResponseDto = new ClientResponseDto();

        clientValidationService.validateClient(client);
        Client clientResponse = repository.save(client);

        if (clientResponse.get_id() != null) {
            clientResponseDto.setRequestStatusEnum(RequestStatusEnum.SUCCESS);
            clientResponseDto.setClient(clientResponse);
        } else {
            clientResponseDto.setRequestStatusEnum(RequestStatusEnum.FAILED);
            clientResponseDto.setNotes("Client creating failed");
        }
        return clientResponseDto;
    }

    @Override
    public ClientResponseDto updateClient(Client client) throws ValidationException {
        ClientResponseDto clientResponseDto = new ClientResponseDto();

        clientValidationService.validateClient(client);

        if (repository.existsById(client.get_id())) {
            clientResponseDto.setClient(repository.save(client));
            clientResponseDto.setRequestStatusEnum(RequestStatusEnum.SUCCESS);
        } else {
            clientResponseDto.setRequestStatusEnum(RequestStatusEnum.FAILED);
            clientResponseDto.setNotes("Client updating failed");
        }
        return clientResponseDto;
    }

    @Override
    public ClientResponseDto deleteClient(String id) {
        ClientResponseDto clientResponseDto = new ClientResponseDto();

        if (repository.existsById(id)) {
            repository.deleteById(id);
            clientResponseDto.setRequestStatusEnum(RequestStatusEnum.SUCCESS);
        } else {
            clientResponseDto.setRequestStatusEnum(RequestStatusEnum.FAILED);
            clientResponseDto.setNotes("Client deletion failed");
        }
        return clientResponseDto;
    }

    @Override
    public Optional<Client> searchClient(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return repository.findAll();
    }
}
