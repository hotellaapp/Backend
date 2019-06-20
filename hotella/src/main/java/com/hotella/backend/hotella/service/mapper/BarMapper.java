package com.hotella.backend.hotella.service.mapper;

import com.hotella.backend.hotella.model.Bar;
import com.hotella.backend.hotella.service.dto.BarDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity Bar and its DTO BarDTO.
 */
@Mapper(componentModel = "spring", uses = {ServicesMapper.class})
public interface BarMapper extends EntityMapper<BarDTO, Bar> {

    @Mapping(source = "services.id", target = "servicesId")
    BarDTO toDto(Bar bar);

    @Mapping(source = "servicesId", target = "services")
    Bar toEntity(BarDTO barDTO);

    default Bar fromId(Long id) {
        if (id == null) {
            return null;
        }
        Bar bar = new Bar();
        bar.setId(id);
        return bar;
    }
}
