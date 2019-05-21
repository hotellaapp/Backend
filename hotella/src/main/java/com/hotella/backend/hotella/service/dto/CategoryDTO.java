package com.hotella.backend.hotella.service.dto;

import com.hotella.backend.hotella.model.enumeration.PaymentType;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class CategoryDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private PaymentType paymentType;

    @NotNull
    private Boolean isActive;

    private Long hotelId;

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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CategoryDTO categoryssDTO = (CategoryDTO) o;
        if (categoryssDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), categoryssDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paymentType=" + paymentType +
                ", isActive=" + isActive +
                ", hotelId=" + hotelId +
                '}';
    }
}
