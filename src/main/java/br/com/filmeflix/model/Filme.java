package br.com.filmeflix.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String genero;
	private Integer duracao;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataLancamento;
	private LocalDateTime dataInsercao = LocalDateTime.now();
	
	public Filme() {
	}
	
	public Filme(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.genero = filme.getGenero();
		this.duracao = filme.getDuracao();
		this.dataLancamento = filme.getDataLancamento();
		this.dataInsercao = filme.getDataInsercao();
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public LocalDateTime getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(LocalDateTime dataInsercao) {
		this.dataInsercao = dataInsercao;
	}
}
