package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Hotel;
import com.hotella.backend.hotella.repository.HotelRepository;
import com.hotella.backend.hotella.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private final Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);

    private final HotelRepository HotelRepository;

    public HotelServiceImpl(HotelRepository HotelRepository) {
        this.HotelRepository = HotelRepository;
    }

    @Override
    public Hotel save(Hotel Hotels) {
        log.debug("Request to save Hotels : {}", Hotels);
        Hotel result = HotelRepository.save(Hotels);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> findAll() {
        log.debug("Request to get all Hotels");
        return HotelRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Hotel> findOne(Long id) {
        log.debug("Request to get Hotels : {}", id);
        return HotelRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Hotels : {}", id);
        HotelRepository.deleteById(id);
    }
}
