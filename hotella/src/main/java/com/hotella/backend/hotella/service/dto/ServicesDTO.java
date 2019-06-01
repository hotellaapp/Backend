package com.hotella.backend.hotella.service.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Services entity.
 */
public class ServicesDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Float price;

    @NotNull
    private Boolean isActive;


    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ServicesDTO servicesDTO = (ServicesDTO) o;
        if (servicesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), servicesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ServicesDTO{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", price=" + getPrice() +
                ", isActive='" + isIsActive() + "'" +
                ", category=" + getCategoryId() +
                "}";
    }
}
