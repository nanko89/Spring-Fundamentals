package com.example.finalexam.repository;

import com.example.finalexam.model.entity.Song;
import com.example.finalexam.model.entity.Style;
import com.example.finalexam.model.entity.enums.StyleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Optional<Song> findByPerformerIgnoreCase(String performer);

    List<Song> findByStyle_Name(StyleName style_name);

}
