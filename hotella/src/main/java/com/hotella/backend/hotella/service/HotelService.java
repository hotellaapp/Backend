package com.hotella.backend.hotella.service;

import com.hotella.backend.hotella.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    Hotel save(Hotel hotel);

    List<Hotel> findAll();

    Optional<Hotel> findOne(Long id);

    void delete(Long id);

}
