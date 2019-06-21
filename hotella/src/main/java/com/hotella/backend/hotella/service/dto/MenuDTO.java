package com.hotella.backend.hotella.service.dto;

import com.hotella.backend.hotella.model.enumeration.FoodRegimen;
import com.hotella.backend.hotella.model.enumeration.FoodType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Menu entity.
 */
public class MenuDTO implements Serializable {

    private Long id;

    @NotNull
    private String foodName;

    private String description;

    @NotNull
    private Float price;

    @NotNull
    private Boolean isActive;

    @NotNull
    private FoodType type;

    @NotNull
    private FoodRegimen regimen;


    private Long servicesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public FoodRegimen getRegimen() {
        return regimen;
    }

    public void setRegimen(FoodRegimen regimen) {
        this.regimen = regimen;
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

        MenuDTO menuDTO = (MenuDTO) o;
        if (menuDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), menuDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "id=" + getId() +
                ", foodName='" + getFoodName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price=" + getPrice() +
                ", isActive='" + isIsActive() + "'" +
                ", type='" + getType() + "'" +
                ", regimen='" + getRegimen() + "'" +
                ", category=" + getServicesId() +
                "}";
    }
}
