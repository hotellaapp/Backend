package com.hotella.backend.hotella.model;


import com.hotella.backend.hotella.model.enumeration.FoodRegimen;
import com.hotella.backend.hotella.model.enumeration.FoodType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MENU")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private Float price;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type", nullable = false)
    private FoodType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "regimen", nullable = false)
    private FoodRegimen regimen;

    @ManyToOne(optional = false)
    @NotNull
    private Services services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public Menu foodName(String foodName) {
        this.foodName = foodName;
        return this;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public Menu description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public Menu price(Float price) {
        this.price = price;
        return this;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Menu isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public FoodType getType() {
        return type;
    }

    public Menu type(FoodType type) {
        this.type = type;
        return this;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public FoodRegimen getRegimen() {
        return regimen;
    }

    public Menu regimen(FoodRegimen regimen) {
        this.regimen = regimen;
        return this;
    }

    public void setRegimen(FoodRegimen regimen) {
        this.regimen = regimen;
    }

    public Services getServices() {
        return services;
    }

    public Menu category(Services services) {
        this.services = services;
        return this;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        if (menu.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), menu.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + getId() +
                ", foodName='" + getFoodName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price=" + getPrice() +
                ", isActive='" + isIsActive() + "'" +
                ", type='" + getType() + "'" +
                ", regimen='" + getRegimen() + "'" +
                "}";
    }
}
