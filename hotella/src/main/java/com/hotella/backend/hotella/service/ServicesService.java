package com.hotella.backend.hotella.service;

import com.hotella.backend.hotella.model.Services;

import java.util.List;
import java.util.Optional;

public interface ServicesService {

    Services save(Services service);

    List<Services> findAll();

    Optional<Services> findOne(Long id);

    void delete(Long id);

}