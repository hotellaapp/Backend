package com.hotella.backend.hotella.service;

import com.hotella.backend.hotella.model.Client;

import java.util.List;
import java.util.Optional;


public interface ClientService {


    Client save(Client client);

    List<Client> findAll();

    Optional<Client> findOne(Long id);

    void delete(Long id);

}
