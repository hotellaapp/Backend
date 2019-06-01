package com.hotella.backend.hotella.service.mapper;

import com.hotella.backend.hotella.model.Services;
import com.hotella.backend.hotella.service.dto.ServicesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Servicess and its DTO ServicesDTO.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ServicesMapper extends EntityMapper<ServicesDTO, Services> {

    @Override
    @Mapping(source = "serviceCategory.id", target = "categoryId")
    ServicesDTO toDto(Services services);

    @Override
    @Mapping(source = "categoryId", target = "serviceCategory")
    Services toEntity(ServicesDTO servicesDTO);

    default Services fromId(Long id) {
        if (id == null) {
            return null;
        }
        Services services = new Services();
        services.setId(id);
        return services;
    }
}
