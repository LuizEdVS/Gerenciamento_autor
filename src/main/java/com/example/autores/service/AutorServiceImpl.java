package com.example.autores.service;

import com.example.autores.domain.Autor;
import com.example.autores.exception.AutorNotFoundException;
import com.example.autores.repository.AutorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService {

	private final AutorRepository autorRepository;

	public AutorServiceImpl(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public Autor criar(Autor autor) {
		return autorRepository.save(autor);
	}

	@Override
	public List<Autor> listarTodos() {
		return autorRepository.findAll();
	}

	@Override
	public Autor buscarPorId(Long id) {
		return autorRepository.findById(id).orElseThrow(() -> new AutorNotFoundException(id));
	}

	@Override
	public void deletarPorId(Long id) {
		if (!autorRepository.existsById(id)) {
			throw new AutorNotFoundException(id);
		}
		autorRepository.deleteById(id);
	}
}

