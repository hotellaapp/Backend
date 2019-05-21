package com.hotella.backend.hotella.model;

import com.hotella.backend.hotella.model.enumeration.Nationality;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "client")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "nationality", nullable = false)
    private Nationality nationality;

    @Column(name = "last_update")
    private Instant lastUpdate;

    @ManyToOne
    private Reservation clientReservation;

    @ManyToOne(optional = false)
    @NotNull
    private Hotel clientHotel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Client name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Client code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Client isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public Client nacionality(Nationality nationality) {
        this.nationality = nationality;
        return this;
    }

    public void setNacionality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public Client lastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Reservation getClientReservation() {
        return clientReservation;
    }

    public Client clientReservation(Reservation reservation) {
        this.clientReservation = reservation;
        return this;
    }

    public void setClientReservation(Reservation reservation) {
        this.clientReservation = reservation;
    }

    public Hotel getClientHotel() {
        return clientHotel;
    }

    public Client clientHotel(Hotel hotel) {
        this.clientHotel = hotel;
        return this;
    }

    public void setClientHotel(Hotel hotel) {
        this.clientHotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        if (client.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", code='" + getCode() + "'" +
                ", isActive='" + isIsActive() + "'" +
                ", nationality='" + getNationality() + "'" +
                ", lastUpdate='" + getLastUpdate() + "'" +
                "}";
    }
}
