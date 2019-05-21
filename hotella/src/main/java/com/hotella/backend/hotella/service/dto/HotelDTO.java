package com.hotella.backend.hotella.service.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class HotelDTO implements Serializable {

    private Long id;

    @NotNull
    private String description;

    @NotNull
    private String linkImage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HotelDTO hotelDTO = (HotelDTO) o;
        if (hotelDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), hotelDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "id=" + getId() +
                ", description='" + getDescription() + "'" +
                ", linkImage='" + getLinkImage() + "'" +
                "}";
    }
}
