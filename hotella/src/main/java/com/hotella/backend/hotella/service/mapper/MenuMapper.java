package com.hotella.backend.hotella.service.mapper;

import com.hotella.backend.hotella.model.Menu;
import com.hotella.backend.hotella.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Menu and its DTO MenuDTO.
 */
@Mapper(componentModel = "spring", uses = {ServicesMapper.class})
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

    @Override
    @Mapping(source = "services.id", target = "servicesId")
    MenuDTO toDto(Menu menu);

    @Override
    @Mapping(source = "servicesId", target = "services")
    Menu toEntity(MenuDTO menuDTO);

    default Menu fromId(Long id) {
        if (id == null) {
            return null;
        }
        Menu menu = new Menu();
        menu.setId(id);
        return menu;
    }
}
