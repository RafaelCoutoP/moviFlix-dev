package com.rafaeldev.moviflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldev.moviflix.dto.InsertReviewDTO;
import com.rafaeldev.moviflix.dto.ReviewDTO;
import com.rafaeldev.moviflix.entities.Movie;
import com.rafaeldev.moviflix.entities.Review;
import com.rafaeldev.moviflix.repositories.MovieRepository;
import com.rafaeldev.moviflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public ReviewDTO insert(InsertReviewDTO dto) {
		Review entity = new Review();
		entity.setText(dto.getText());
		Movie movie = movieRepository.getOne(dto.getMovieID());
		entity.setMovie(movie);
		entity = repository.save(entity);									
		return new ReviewDTO(entity);
	}

	/*private void copyDtoToEntity(InsertReviewDTO dto, Review entity) {
		entity.setText(dto.getText());
		Movie mov = dto.getMovieId() == 0 ? null : movieRepository.getOne(dto.getMovieId());
		entity.setMovie(mov);
		//Possivel problema estejá aqui nesse trecho.
		User user = userRepository.getOne(dto.getUser().getId());
		entity.setUser(user);
	}*/
}