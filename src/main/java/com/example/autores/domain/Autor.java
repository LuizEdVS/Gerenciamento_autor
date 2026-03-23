package com.example.autores.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity(name = "Autor")
@Table(name = "tb_autor")
public class Autor {

	private Long id;

	@Column(name = "nome_autor")
	private String nome;

	@Column(name = "nacionalidade_autor")
	private String nacionalidade;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	public Autor() {
	}

	public Autor(Long id, String nome, String nacionalidade, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}

