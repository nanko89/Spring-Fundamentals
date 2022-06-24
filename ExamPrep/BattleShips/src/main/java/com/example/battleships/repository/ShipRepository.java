package com.example.battleships.repository;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByNameIgnoreCase(String username);

}