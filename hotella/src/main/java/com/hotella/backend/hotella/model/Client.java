package com.hotella.backend.hotella.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client extends BasicUser {
}
