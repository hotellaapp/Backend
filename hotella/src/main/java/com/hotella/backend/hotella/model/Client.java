package com.hotella.backend.hotella.model;

import com.hotella.backend.hotella.model.enumeration.Nationality;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="CLIENT")
public class Client extends BasicUser {

    private String firstname;

    private String lastname;

    private Nationality nationality;



    public Client(int id, @NotNull @Email String email, @NotNull String password, Set<Role> roles, String firstname, String lastname, Nationality nationality) {
        super(id, email, password, roles);
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationality = nationality;
    }
}
