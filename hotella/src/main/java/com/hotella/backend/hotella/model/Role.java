package com.hotella.backend.hotella.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "definition")
    private String definition;

    public Role() {
    }

    public Role(int id, String definition) {
        this.id = id;
        this.definition = definition;
    }


}
