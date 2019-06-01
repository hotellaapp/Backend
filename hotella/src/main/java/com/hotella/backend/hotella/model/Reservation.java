package com.hotella.backend.hotella.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "RESERVATION")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "client_name", nullable = false)
    private String clientName;

    @NotNull
    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "paid_quantity")
    private Double paidQuantity;

    @NotNull
    @Column(name = "paid", nullable = false)
    private Boolean paid;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private Instant endDate;

    @Column(name = "additional_information")
    private String additionalInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public Reservation clientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContact() {
        return contact;
    }

    public Reservation contact(String contact) {
        this.contact = contact;
        return this;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Double getPaidQuantity() {
        return paidQuantity;
    }

    public Reservation paidQuantity(Double paidQuantity) {
        this.paidQuantity = paidQuantity;
        return this;
    }

    public void setPaidQuantity(Double paidQuantity) {
        this.paidQuantity = paidQuantity;
    }

    public Boolean isPaid() {
        return paid;
    }

    public Reservation paid(Boolean paid) {
        this.paid = paid;
        return this;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Reservation startDate(Instant startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Reservation endDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public Reservation additionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reservation reservation = (Reservation) o;
        if (reservation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reservation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + getId() +
                ", clientName='" + getClientName() + "'" +
                ", contact='" + getContact() + "'" +
                ", paidQuantity=" + getPaidQuantity() +
                ", paid='" + isPaid() + "'" +
                ", startDate='" + getStartDate() + "'" +
                ", endDate='" + getEndDate() + "'" +
                ", additionalInformation='" + getAdditionalInformation() + "'" +
                "}";
    }
}
