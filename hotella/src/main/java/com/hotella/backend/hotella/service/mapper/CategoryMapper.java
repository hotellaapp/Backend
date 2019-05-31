package com.hotella.backend.hotella.service.mapper;

import com.hotella.backend.hotella.model.Category;
import com.hotella.backend.hotella.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

    @Override
    CategoryDTO toDto(Category category);

    @Override
    Category toEntity(CategoryDTO categoryDTO);

    default Category fromId(Long id) {
        if (id == null) {
            return null;
        }
        Category category = new Category();
        category.setId(id);
        return category;
    }
}
