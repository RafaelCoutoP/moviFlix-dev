package com.rafaeldev.moviflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaeldev.moviflix.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
