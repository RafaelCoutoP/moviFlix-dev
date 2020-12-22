package com.rafaeldev.moviflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldev.moviflix.dto.GenreDTO;
import com.rafaeldev.moviflix.entities.Genre;
import com.rafaeldev.moviflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;

	@Transactional(readOnly = true)
	public List<GenreDTO> findAll(){
	List<Genre> list = repository.findAll();
	return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}
}
