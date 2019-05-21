package com.hotella.backend.hotella.service.mapper;

import com.hotella.backend.hotella.model.Hotel;
import com.hotella.backend.hotella.service.dto.HotelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface HotelMapper extends EntityMapper<HotelDTO, Hotel> {


    default Hotel fromId(Long id) {
        if (id == null) {
            return null;
        }
        Hotel hotel = new Hotel();
        hotel.setId(id);
        return hotel;
    }
}

