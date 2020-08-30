package br.com.filmeflix.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Setter @Getter @NoArgsConstructor
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
	
	
	public Filme(Filme filme) {
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.genero = filme.getGenero();
		this.duracao = filme.getDuracao();
		this.dataLancamento = filme.getDataLancamento();
		this.dataInsercao = filme.getDataInsercao();
	}

}
