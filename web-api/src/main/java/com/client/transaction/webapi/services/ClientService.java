package com.client.transaction.webapi.services;

import com.client.transaction.webapi.dtos.ClientDto;
import com.client.transaction.webapi.dtos.response.ResponseDto;

import java.util.List;

public interface ClientService {

    /**
     * Create a new client.
     *
     * @param clientDto containing details of the new client to be created.
     * @return ResponseDto of the created client containing response status code.
     */
    public ResponseDto createClient(ClientDto clientDto);

    /**
     * Update existing client.
     *
     * @param clientDto containing new values to update existing client information with.
     * @return ResponseDto of the updated client containing response status code.
     */
    public ResponseDto updateClient(ClientDto clientDto);

    /**
     * Delete existing client.
     * @param id of the target client to be deleted.
     * @return ResponseDto of the deleted client containing response status code.
     */
    public ResponseDto deleteClient(int id);

    /**
     * Search for all clients matching the argument string.
     * @param string to use for searching existing clients.
     * @return A list of all clients matching the argument string partially or completely.
     */
    public List<ClientDto> searchClient(String string);


}
