package com.hotella.backend.hotella.model;

import javax.persistence.*;

@Entity
@Table(name ="ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="fk_basic_user")
    private int fkBasicUser;

    public Role() {
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
