package com.client.transaction.webapi.persistance.repositories;

import com.client.transaction.webapi.persistance.model.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientModel, String> {
}
