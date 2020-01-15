package com.springboothackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboothackathon.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
