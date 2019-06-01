package com.hotella.backend.hotella.service;

import com.hotella.backend.hotella.service.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryDTO save(CategoryDTO categoryDTO);

    List<CategoryDTO> findAll();

    Optional<CategoryDTO> findOne(Long id);

    void delete(Long id);

}
