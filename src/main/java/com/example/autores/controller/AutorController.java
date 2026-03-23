package com.example.autores.controller;

import com.example.autores.domain.Autor;
import com.example.autores.exception.AutorNotFoundException;
import com.example.autores.service.AutorService;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorService autorService;

	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}

	@PostMapping
	public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor) {
		Autor salvo = autorService.criar(autor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(salvo.getId())
				.toUri();
		return ResponseEntity.created(location).body(salvo);
	}

	@GetMapping
	public List<Autor> listarAutores() {
		return autorService.listarTodos();
	}

	@GetMapping("/{id}")
	public Autor buscarAutorPorId(@PathVariable Long id) {
		return autorService.buscarPorId(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
		autorService.deletarPorId(id);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(AutorNotFoundException.class)
	public ResponseEntity<Void> handleAutorNotFound(AutorNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}

