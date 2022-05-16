package com.example.springmobilele.repository;


import com.example.springmobilele.models.entity.UserRole;
import com.example.springmobilele.models.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(Role role);
}
