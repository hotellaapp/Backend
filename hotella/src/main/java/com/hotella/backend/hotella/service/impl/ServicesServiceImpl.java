package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Services;
import com.hotella.backend.hotella.repository.ServicesRepository;
import com.hotella.backend.hotella.service.ServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ServicesServiceImpl implements ServicesService {

    private final Logger log = LoggerFactory.getLogger(ServicesServiceImpl.class);

    private final ServicesRepository servicesRepository;

    public ServicesServiceImpl(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    public Services save(Services services) {
        log.info("Request to save Services : {}", services);
        Services result = servicesRepository.save(services);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Services> findAll() {
        log.info("Request to get all Services");
        return servicesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Services> findOne(Long id) {
        log.info("Request to get Services : {}", id);
        return servicesRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete Services : {}", id);
        servicesRepository.deleteById(id);
    }
}
