package com.client.transaction.webapi.services;

import com.client.transaction.webapi.dtos.response.ResponseDto;
import com.client.transaction.webapi.exceptions.ValidationException;
import com.client.transaction.webapi.persistance.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    /**
     * Create a new client.
     *
     * @param client containing details of the new client to be created.
     * @return ResponseDto of the created client containing response status code.
     */
    public ResponseDto createClient(Client client) throws ValidationException;

    /**
     * Update existing client.
     *
     * @param client containing new values to update existing client information with.
     * @return ResponseDto of the updated client containing response status code.
     */
    public ResponseDto updateClient(Client client) throws ValidationException;

    /**
     * Delete existing client.
     *
     * @param id of the target client to be deleted.
     * @return ResponseDto of the deleted client containing response status code.
     */
    public ResponseDto deleteClient(String id);

    /**
     * Search for all clients matching the argument string.
     *
     * @param string to use for searching existing clients.
     * @return A list of all clients matching the argument string partially or completely.
     */
    public Optional<Client> searchClient(String string);

    /**
     * Search for all clients.
     *
     * @return A list of all clients matching the argument string partially or completely.
     */
    public List<Client> getAllClients();
}