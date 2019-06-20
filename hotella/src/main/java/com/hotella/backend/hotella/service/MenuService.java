package com.hotella.backend.hotella.service;

import com.hotella.backend.hotella.service.dto.MenuDTO;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    MenuDTO save(MenuDTO menuDTO);

    List<MenuDTO> findAll();

    Optional<MenuDTO> findOne(Long id);

    void delete(Long id);
}
