package com.client.transaction.webapi.controllers;

import com.client.transaction.webapi.dtos.ClientDto;
import com.client.transaction.webapi.dtos.response.ClientResponseDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class.getName());


    @PostMapping("/create-client")
    @ApiOperation(value = "Create a new client",
            notes = "Create a new client with the argument clientDto",
            response = ClientResponseDto.class)
    public ClientResponseDto createClient(@RequestBody ClientDto clientDto) {
        LOGGER.info("Creating client with name: {}", clientDto.getFullName());
        ClientResponseDto clientResponseDto = new ClientResponseDto();

        return clientResponseDto;
    }

    @GetMapping("/get-client/{id}")
    @ApiOperation(value = "Get client",
            notes = "Get client of argument id",
            response = ClientResponseDto.class)
    public ClientDto getClient(@RequestBody ClientDto clientDto) {
        LOGGER.info("Retrieving client with id and name: {}, {}", clientDto.id, clientDto.getFullName());

        return clientDto;
    }

    @PutMapping("/update-client")
    public ClientDto updateClient(@RequestBody ClientDto clientDto) {
        LOGGER.info("Updating client with id and name: {}, {}", clientDto.id, clientDto.getFullName());

        return clientDto;
    }

    @PutMapping("/delete-client/{clientId}")
    public String updateClient(@PathVariable int clientId) {
        LOGGER.info("Deleting client with id : {}", clientId);

        return "Success";
    }


}
