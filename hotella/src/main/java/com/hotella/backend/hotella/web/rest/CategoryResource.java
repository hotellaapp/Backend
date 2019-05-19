package com.hotella.backend.hotella.web.rest;

import com.hotella.backend.hotella.model.Category;
import com.hotella.backend.hotella.service.CategoryService;
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
public class CategoryResource {

    private final Logger log = LoggerFactory.getLogger(CategoryResource.class);

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
        log.info("REST request to save Category : {}", category);
        if (category.getId() != null) {
            return new ResponseEntity<>(category, HttpStatus.BAD_REQUEST);
        }
        Category result = categoryService.save(category);
        return ResponseEntity.created(new URI("/api/category/" + result.getId()))
                .body(result);
    }

    @PutMapping("/category")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) {
        log.info("REST request to update Category : {}", category);
        if (category.getId() == null) {
            return new ResponseEntity<>(category, HttpStatus.BAD_REQUEST);
        }
        Category result = categoryService.save(category);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/category")
    public List<Category> getAllCategory() {
        log.info("REST request to get all Category");
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        log.info("REST request to get Category : {}", id);
        Optional<Category> category = categoryService.findOne(id);
        if (category.isPresent()) {
            return ResponseEntity.ok().body(category.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        log.info("REST request to delete Category : {}", id);
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
