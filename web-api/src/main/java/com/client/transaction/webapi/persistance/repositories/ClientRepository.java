package com.client.transaction.webapi.persistance.repositories;

import com.client.transaction.webapi.persistance.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    public Client findByFirstName(String firstName);

    public List<Client> findByLastName(String lastName);

}
