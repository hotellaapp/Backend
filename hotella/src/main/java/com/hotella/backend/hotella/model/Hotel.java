package com.hotella.backend.hotella.model;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hotel")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "linkImage")
    private String linkImage;

    public Hotel(String description, String linkImage) {
        this.description = description;
        this.linkImage = linkImage;
    }

    public Hotel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Hotel description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public Hotel linkImage(String linkImage) {
        this.linkImage = linkImage;
        return this;
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
        Hotel hotel = (Hotel) o;
        if (hotel.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), hotel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", linkImage='" + linkImage + '\'' +
                '}';
    }
}
