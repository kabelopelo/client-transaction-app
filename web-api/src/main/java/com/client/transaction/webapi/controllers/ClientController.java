package com.client.transaction.webapi.controllers;

import com.client.transaction.webapi.dtos.response.ClientResponseDto;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Client;
import com.client.transaction.webapi.services.ClientService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class.getName());


    @PostMapping("/create-client")
    @ApiOperation(value = "Create a new client",
            notes = "Create a new client with the argument clientDto",
            response = ClientResponseDto.class)
    public ClientResponseDto createClient(@RequestBody Client client) throws ValidationException {
        LOGGER.info("Creating client with name: {}", client.getFullName());

        return clientService.createClient(client);
    }

    @GetMapping("/get-client/{id}")
    @ApiOperation(value = "Get client",
            notes = "Get client of argument id",
            response = ClientResponseDto.class)
    public Optional<Client> getClient(@PathVariable String id) {
        LOGGER.info("Retrieving client with id {}", id);

        return clientService.searchClient(id);
    }

    @GetMapping("/get-all-clients")
    @ApiOperation(value = "Get all clients",
            notes = "Get all clients",
            response = ClientResponseDto.class)
    public List<Client> getClients() {
        LOGGER.info("Retrieving all clients");

        return clientService.getAllClients();
    }

    @PutMapping("/update-client")
    public ClientResponseDto updateClient(@RequestBody Client client) throws ValidationException {
        LOGGER.info("Updating client with id and name: {}, {}", client.get_id(), client.getFullName());

        return clientService.updateClient(client);
    }

    @DeleteMapping("/delete-client/{clientId}")
    public ClientResponseDto updateClient(@PathVariable String clientId) {
        LOGGER.info("Deleting client with id : {}", clientId);

        return clientService.deleteClient(clientId);
    }


}
