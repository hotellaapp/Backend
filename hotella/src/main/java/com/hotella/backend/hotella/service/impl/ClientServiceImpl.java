package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Client;
import com.hotella.backend.hotella.repository.ClientRepository;
import com.hotella.backend.hotella.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        log.info("Request to save Client : {}", client);
        Client result = clientRepository.save(client);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        log.info("Request to get all Clients");
        return clientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findOne(Long id) {
        log.info("Request to get Client : {}", id);
        return clientRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete Client : {}", id);
        clientRepository.deleteById(id);
    }
}
