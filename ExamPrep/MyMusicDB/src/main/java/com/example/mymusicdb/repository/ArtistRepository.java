package com.example.mymusicdb.repository;

import com.example.mymusicdb.model.entity.Artist;
import com.example.mymusicdb.model.entity.enums.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByName(ArtistName name);

}