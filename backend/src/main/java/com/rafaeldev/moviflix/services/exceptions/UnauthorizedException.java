package com.rafaeldev.moviflix.services.exceptions;

public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	// não há autenticação
	public UnauthorizedException (String msg) {
		super(msg);
	}
}