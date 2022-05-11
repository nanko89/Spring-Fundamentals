package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> userEntity;

    public Role() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public Role setRole(RoleEnum name) {
        this.role = name;
        return this;
    }

    public Set<User> getUserEntity() {
        return userEntity;
    }

    public Role setUserEntity(Set<User> userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
