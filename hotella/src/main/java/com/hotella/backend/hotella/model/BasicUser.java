package com.hotella.backend.hotella.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Set;


public abstract class BasicUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;


    private String email;

    private String password;

    private String passwordCheck;

    private Set<Role> roles;

}
