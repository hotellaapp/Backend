package com.hotella.backend.hotella.service.impl;

import com.hotella.backend.hotella.model.Menu;
import com.hotella.backend.hotella.repository.MenuRepository;
import com.hotella.backend.hotella.service.MenuService;
import com.hotella.backend.hotella.service.dto.MenuDTO;
import com.hotella.backend.hotella.service.mapper.MenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    private final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuRepository menuRepository, MenuMapper menuMapper) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
    }

    @Override
    public MenuDTO save(MenuDTO menuDTO) {
        log.info("Request to save Menu : {}", menuDTO);
        Menu menu = menuMapper.toEntity(menuDTO);
        menu = menuRepository.save(menu);
        MenuDTO result = menuMapper.toDto(menu);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuDTO> findAll() {
        log.info("Request to get all Menus");
        return menuRepository.findAll().stream()
                .map(menuMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MenuDTO> findOne(Long id) {
        log.info("Request to get Menu : {}", id);
        return menuRepository.findById(id)
                .map(menuMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete Menu : {}", id);
        menuRepository.deleteById(id);
    }

}
