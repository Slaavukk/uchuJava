package com.example.demo.entity;

import com.example.demo.entity.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private Roles roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
