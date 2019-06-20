package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Bar;
import com.hotella.backend.hotella.repository.BarRepository;
import com.hotella.backend.hotella.service.BarService;
import com.hotella.backend.hotella.service.dto.BarDTO;
import com.hotella.backend.hotella.service.mapper.BarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Bar.
 */
@Service
@Transactional
public class BarServiceImpl implements BarService {

    private final Logger log = LoggerFactory.getLogger(BarServiceImpl.class);

    private final BarRepository barRepository;

    private final BarMapper barMapper;

    public BarServiceImpl(BarRepository barRepository, BarMapper barMapper) {
        this.barRepository = barRepository;
        this.barMapper = barMapper;
    }

    /**
     * Save a bar.
     *
     * @param barDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BarDTO save(BarDTO barDTO) {
        log.debug("Request to save Bar : {}", barDTO);
        Bar bar = barMapper.toEntity(barDTO);
        bar = barRepository.save(bar);
        return barMapper.toDto(bar);
    }

    /**
     * Get all the bars.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BarDTO> findAll() {
        log.debug("Request to get all Bars");
        return barRepository.findAll().stream()
            .map(barMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one bar by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BarDTO> findOne(Long id) {
        log.debug("Request to get Bar : {}", id);
        return barRepository.findById(id)
            .map(barMapper::toDto);
    }

    /**
     * Delete the bar by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Bar : {}", id);
        barRepository.deleteById(id);
    }
}
