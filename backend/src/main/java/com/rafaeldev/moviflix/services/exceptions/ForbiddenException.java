package com.rafaeldev.moviflix.services.exceptions;

public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//Não há permissão 
	public ForbiddenException (String msg) {
		super(msg);
	}
}