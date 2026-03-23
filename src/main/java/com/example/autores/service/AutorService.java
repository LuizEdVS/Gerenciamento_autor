package com.example.autores.service;

import com.example.autores.domain.Autor;
import java.util.List;

public interface AutorService {

	Autor criar(Autor autor);

	List<Autor> listarTodos();

	Autor buscarPorId(Long id);

	void deletarPorId(Long id);
}

