package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleEnum;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public Role() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public Role setRole(RoleEnum name) {
        this.role = name;
        return this;
    }
}
