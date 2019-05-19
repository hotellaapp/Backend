package com.hotella.backend.hotella.repository;

import com.hotella.backend.hotella.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
