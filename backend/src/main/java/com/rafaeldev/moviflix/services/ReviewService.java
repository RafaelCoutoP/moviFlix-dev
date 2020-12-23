package com.rafaeldev.moviflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldev.moviflix.dto.ReviewDTO;
import com.rafaeldev.moviflix.entities.Movie;
import com.rafaeldev.moviflix.entities.Review;
import com.rafaeldev.moviflix.entities.User;
import com.rafaeldev.moviflix.repositories.MovieRepository;
import com.rafaeldev.moviflix.repositories.ReviewRepository;
import com.rafaeldev.moviflix.repositories.UserRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		Review entity = new Review();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);									
		return new ReviewDTO(entity);
	}

	private void copyDtoToEntity(ReviewDTO dto, Review entity) {
		entity.setText(dto.getText());
		Movie mov = dto.getMovieId() == 0 ? null : movieRepository.getOne(dto.getMovieId());
		entity.setMovie(mov);
		//Possivel problema estejá aqui nesse trecho.
		User user = userRepository.getOne(dto.getUser().getId());
		entity.setUser(user);
	}
}