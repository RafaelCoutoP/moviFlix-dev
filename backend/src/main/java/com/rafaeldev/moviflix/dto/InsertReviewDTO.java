package com.rafaeldev.moviflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class InsertReviewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Avaliação do filme não pode ser em branco, favor inserir um comentário!")
	private String text;
	private Long movieId;
	
	public InsertReviewDTO() {
	}

	public Long getMovieID() {
		return movieId;
	}

	public void setMovieID(Long movieID) {
		this.movieId = movieID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
