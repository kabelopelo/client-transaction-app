package com.client.transaction.webapi.impl;

import com.client.transaction.webapi.dtos.ClientDto;
import com.client.transaction.webapi.dtos.response.ResponseDto;
import com.client.transaction.webapi.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class.getName());


    @Override
    public ResponseDto createClient(ClientDto clientDto) {
        return null;
    }

    @Override
    public ResponseDto updateClient(ClientDto clientDto) {
        return null;
    }

    @Override
    public ResponseDto deleteClient(int id) {
        return null;
    }

    @Override
    public List<ClientDto> searchClient(String string) {
        return null;
    }
}
