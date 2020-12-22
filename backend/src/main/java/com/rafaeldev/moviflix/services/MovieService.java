package com.rafaeldev.moviflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldev.moviflix.dto.MovieDTO;
import com.rafaeldev.moviflix.entities.Genre;
import com.rafaeldev.moviflix.entities.Movie;
import com.rafaeldev.moviflix.repositories.GenreRepository;
import com.rafaeldev.moviflix.repositories.MovieRepository;
import com.rafaeldev.moviflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> find(Long genreId, Pageable pageble){
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId); 
		Page<Movie> page = repository.find(genre, pageble);
		return page.map(x -> new MovieDTO(x));
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id); // se for nulo lança o resource notFoud.
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
		return new MovieDTO(entity);
	}
}
