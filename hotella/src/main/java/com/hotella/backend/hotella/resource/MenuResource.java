package com.hotella.backend.hotella.resource;

import com.hotella.backend.hotella.service.MenuService;
import com.hotella.backend.hotella.service.dto.MenuDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MenuResource {

    private final Logger log = LoggerFactory.getLogger(MenuResource.class);

    private final MenuService menuService;

    public MenuResource(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/menus")
    public ResponseEntity<MenuDTO> createMenu(@Valid @RequestBody MenuDTO menuDTO) throws URISyntaxException {
        log.info("REST request to save Menu : {}", menuDTO);
        if (menuDTO.getId() != null) {
            return new ResponseEntity<>(menuDTO, HttpStatus.BAD_REQUEST);
        }
        MenuDTO result = menuService.save(menuDTO);
        return ResponseEntity.created(new URI("/api/category/" + result.getId()))
                .body(result);
    }

    @PutMapping("/menus")
    public ResponseEntity<MenuDTO> updateMenu(@Valid @RequestBody MenuDTO menuDTO) throws URISyntaxException {
        log.info("REST request to update Menu : {}", menuDTO);
        if (menuDTO.getId() == null) {
            return new ResponseEntity<>(menuDTO, HttpStatus.BAD_REQUEST);
        }
        MenuDTO result = menuService.save(menuDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/menus")
    public List<MenuDTO> getAllMenus() {
        log.debug("REST request to get all Menus");
        return menuService.findAll();
    }

    @GetMapping("/menus/{id}")
    public ResponseEntity<MenuDTO> getMenu(@PathVariable Long id) {
        log.info("REST request to get Menu : {}", id);
        Optional<MenuDTO> menuDTO = menuService.findOne(id);
        if (menuDTO.isPresent()) {
            return ResponseEntity.ok().body(menuDTO.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/menus/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        log.info("REST request to delete Menu : {}", id);
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }

}
