package com.hotella.backend.hotella.service;

import com.hotella.backend.hotella.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation save(Reservation reservationDTO);

    List<Reservation> findAll();

    Optional<Reservation> findOne(Long id);

    void delete(Long id);
}
