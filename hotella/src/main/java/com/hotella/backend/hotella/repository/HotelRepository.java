package com.hotella.backend.hotella.repository;

import com.hotella.backend.hotella.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    Hotel findByIdHotel(int id);
}
