package com.hotella.backend.hotella.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Information entity.
 */
public class InformationDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String address;

    private String telephone;

    private String email;

    private String longitude;

    private String latitude;

    private String imageUrl;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InformationDTO informationDTO = (InformationDTO) o;
        if (informationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), informationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "InformationDTO{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", address='" + getAddress() + "'" +
                ", telephone='" + getTelephone() + "'" +
                ", email='" + getEmail() + "'" +
                ", longitude='" + getLongitude() + "'" +
                ", latitude='" + getLatitude() + "'" +
                ", imageUrl='" + getImageUrl() + "'" +
                "}";
    }
}
