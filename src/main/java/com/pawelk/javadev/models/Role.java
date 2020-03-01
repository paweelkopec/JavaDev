package com.pawelk.javadev.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
