package com.hotella.backend.hotella.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="EMPLOYEE")
public class Employee extends BasicUser {

    public Employee(int id, @NotNull @Email String email, @NotNull String password, Set<Role> roles) {
        super(id, email, password, roles);
    }


}
