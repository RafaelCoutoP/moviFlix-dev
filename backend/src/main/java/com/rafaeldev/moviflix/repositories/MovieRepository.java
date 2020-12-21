package com.rafaeldev.moviflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaeldev.moviflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
