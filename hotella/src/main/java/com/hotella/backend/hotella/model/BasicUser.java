package com.hotella.backend.hotella.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "passwordCheck", nullable = false)
    private String passwordCheck;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Role> roles;


}
