package com.hotella.backend.hotella.service.mapper;

import com.hotella.backend.hotella.model.Category;
import com.hotella.backend.hotella.service.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {HotelMapper.class})
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

    @Override
    @Mapping(source = "clientHotel.id", target = "hotelId")
    CategoryDTO toDto(Category category);

    @Override
    @Mapping(source = "hotelId", target = "clientHotel")
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
