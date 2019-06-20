package com.hotella.backend.hotella.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

import com.hotella.backend.hotella.model.enumeration.DrinkType;

/**
 * A DTO for the Bar entity.
 */
public class BarDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Float price;

    private String description;

    @NotNull
    private Boolean isActive;

    private String image;

    @NotNull
    private DrinkType drinkType;

    private Long servicesId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public Long getServicesId() {
        return servicesId;
    }

    public void setServicesId(Long servicesId) {
        this.servicesId = servicesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BarDTO barDTO = (BarDTO) o;
        if (barDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), barDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BarDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", price=" + getPrice() +
            ", description='" + getDescription() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", image='" + getImage() + "'" +
            ", drinkType='" + getDrinkType() + "'" +
            ", services=" + getServicesId() +
            "}";
    }
}
