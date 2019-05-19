package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Reservation;
import com.hotella.backend.hotella.repository.ReservationRepository;
import com.hotella.backend.hotella.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private final ReservationRepository ReservationRepository;

    public ReservationServiceImpl(ReservationRepository ReservationRepository) {
        this.ReservationRepository = ReservationRepository;
    }

    @Override
    public Reservation save(Reservation Reservations) {
        log.debug("Request to save Reservations : {}", Reservations);
        Reservation result = ReservationRepository.save(Reservations);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        log.debug("Request to get all Reservations");
        return ReservationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reservation> findOne(Long id) {
        log.debug("Request to get Reservations : {}", id);
        return ReservationRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reservations : {}", id);
        ReservationRepository.deleteById(id);
    }
}
