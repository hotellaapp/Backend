package com.hotella.backend.hotella.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotella.backend.hotella.model.enumeration.DrinkType;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;


/**
 * A Bar.
 */
@Entity
@Table(name = "bar")
public class Bar implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "image")
    private String image;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "drink_type", nullable = false)
    private DrinkType drinkType;

    @ManyToOne
    @JsonIgnoreProperties("bars")
    private Services services;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Bar name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public Bar price(Float price) {
        this.price = price;
        return this;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Bar description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Bar isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return image;
    }

    public Bar image(String image) {
        this.image = image;
        return this;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public Bar drinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
        return this;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public Services getServices() {
        return services;
    }

    public Bar services(Services services) {
        this.services = services;
        return this;
    }

    public void setServices(Services services) {
        this.services = services;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bar bar = (Bar) o;
        if (bar.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bar.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Bar{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", price=" + getPrice() +
            ", description='" + getDescription() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", image='" + getImage() + "'" +
            ", drinkType='" + getDrinkType() + "'" +
            "}";
    }
}
