package com.rafaeldev.moviflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldev.moviflix.dto.MovieDTO;
import com.rafaeldev.moviflix.entities.Movie;
import com.rafaeldev.moviflix.repositories.MovieRepository;
import com.rafaeldev.moviflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id); // se for nulo lança o resource notFoud.
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
		return new MovieDTO(entity);
	}
}
