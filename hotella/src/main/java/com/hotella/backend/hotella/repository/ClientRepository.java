package com.hotella.backend.hotella.repository;

import com.hotella.backend.hotella.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    List<Client> findAll();

    Client findbyUsername(String username);




}
