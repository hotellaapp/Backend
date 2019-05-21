package com.hotella.backend.hotella.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="role")
    private String role;



}
