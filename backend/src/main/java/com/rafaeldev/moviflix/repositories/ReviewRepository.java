package com.rafaeldev.moviflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaeldev.moviflix.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
