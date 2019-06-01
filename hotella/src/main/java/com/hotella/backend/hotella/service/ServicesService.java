package com.hotella.backend.hotella.service;

import com.hotella.backend.hotella.service.dto.ServicesDTO;

import java.util.List;
import java.util.Optional;

public interface ServicesService {

    ServicesDTO save(ServicesDTO servicesDTO);

    List<ServicesDTO> findAll();

    Optional<ServicesDTO> findOne(Long id);

    void delete(Long id);

}