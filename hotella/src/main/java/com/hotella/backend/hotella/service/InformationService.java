package com.hotella.backend.hotella.service;

import com.ultra.gate.service.dto.InformationDTO;

import java.util.List;
import java.util.Optional;


public interface InformationService {

    InformationDTO save(InformationDTO informationDTO);

    List<InformationDTO> findAll();

    Optional<InformationDTO> findOne(Long id);

    void delete(Long id);
}
