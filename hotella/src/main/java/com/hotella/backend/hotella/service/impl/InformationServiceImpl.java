package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Information;
import com.hotella.backend.hotella.repository.InformationRepository;
import com.hotella.backend.hotella.service.InformationService;
import com.hotella.backend.hotella.service.dto.InformationDTO;
import com.hotella.backend.hotella.service.mapper.InformationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class InformationServiceImpl implements InformationService {

    private final Logger log = LoggerFactory.getLogger(InformationServiceImpl.class);

    private final InformationRepository informationRepository;

    private final InformationMapper informationMapper;

    public InformationServiceImpl(InformationRepository informationRepository, InformationMapper informationMapper) {
        this.informationRepository = informationRepository;
        this.informationMapper = informationMapper;
    }

    @Override
    public InformationDTO save(InformationDTO informationDTO) {
        log.debug("Request to save Information : {}", informationDTO);
        Information information = informationMapper.toEntity(informationDTO);
        information = informationRepository.save(information);
        InformationDTO result = informationMapper.toDto(information);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InformationDTO> findAll() {
        log.debug("Request to get all Information");
        return informationRepository.findAll().stream()
                .map(informationMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InformationDTO> findOne(Long id) {
        log.debug("Request to get Information : {}", id);
        return informationRepository.findById(id)
                .map(informationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Information : {}", id);
        informationRepository.deleteById(id);
    }
}
