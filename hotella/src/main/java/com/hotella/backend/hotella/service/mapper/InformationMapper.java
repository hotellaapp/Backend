package com.hotella.backend.hotella.service.mapper;

import com.hotella.backend.hotella.model.Information;
import com.ultra.gate.service.dto.InformationDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Information and its DTO InformationDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface InformationMapper extends EntityMapper<InformationDTO, Information> {


    default Information fromId(Long id) {
        if (id == null) {
            return null;
        }
        Information information = new Information();
        information.setId(id);
        return information;
    }
}
