package com.example.autores.exception;

public class AutorNotFoundException extends RuntimeException {

	public AutorNotFoundException(Long id) {
		super("Autor com id " + id + " não encontrado");
	}
}

