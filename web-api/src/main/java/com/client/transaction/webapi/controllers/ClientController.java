package com.client.transaction.webapi.controllers;

import com.client.transaction.webapi.dtos.response.ClientResponseDto;
import com.client.transaction.webapi.persistance.model.Client;
import com.client.transaction.webapi.services.ClientService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ClientResponseDto createClient(@RequestBody Client client) {
        LOGGER.info("Creating client with name: {}", client.getFullName());

        Object o = clientService.createClient(client);

        return null;
    }

    @GetMapping("/get-client/{id}")
    @ApiOperation(value = "Get client",
            notes = "Get client of argument id",
            response = ClientResponseDto.class)
    public Client getClient(@RequestBody Client clientDto) {
        LOGGER.info("Retrieving client with id and name: {}, {}", clientDto.get_id(), clientDto.getFullName());

        return clientDto;
    }

    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client clientDto) {
        LOGGER.info("Updating client with id and name: {}, {}", clientDto.get_id(), clientDto.getFullName());

        return clientDto;
    }

    @PutMapping("/delete-client/{clientId}")
    public String updateClient(@PathVariable int clientId) {
        LOGGER.info("Deleting client with id : {}", clientId);

        return "Success";
    }


}
