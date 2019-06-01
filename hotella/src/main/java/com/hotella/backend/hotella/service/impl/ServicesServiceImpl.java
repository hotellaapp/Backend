package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Services;
import com.hotella.backend.hotella.repository.ServicesRepository;
import com.hotella.backend.hotella.service.ServicesService;
import com.hotella.backend.hotella.service.dto.ServicesDTO;
import com.hotella.backend.hotella.service.mapper.ServicesMapper;
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
public class ServicesServiceImpl implements ServicesService {

    private final Logger log = LoggerFactory.getLogger(ServicesServiceImpl.class);

    private final ServicesRepository servicesRepository;

    private final ServicesMapper servicesMapper;

    public ServicesServiceImpl(ServicesRepository servicesRepository, ServicesMapper servicesMapper) {
        this.servicesRepository = servicesRepository;
        this.servicesMapper = servicesMapper;
    }

    @Override
    public ServicesDTO save(ServicesDTO servicesDTO) {
        log.debug("Request to save Servicess : {}", servicesDTO);
        Services services = servicesMapper.toEntity(servicesDTO);
        services = servicesRepository.save(services);
        ServicesDTO result = servicesMapper.toDto(services);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServicesDTO> findAll() {
        log.debug("Request to get all Serviceses");
        return servicesRepository.findAll().stream()
                .map(servicesMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ServicesDTO> findOne(Long id) {
        log.debug("Request to get Servicess : {}", id);
        return servicesRepository.findById(id)
                .map(servicesMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Servicess : {}", id);
        servicesRepository.deleteById(id);
    }
}
