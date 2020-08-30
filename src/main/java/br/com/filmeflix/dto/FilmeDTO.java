package br.com.filmeflix.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.filmeflix.model.Filme;
import lombok.Getter;

@Getter
public class FilmeDTO {
	
	private String nome;
	private String genero;
	private Integer duracao;
	private LocalDate dataLancamento;

	public FilmeDTO(Filme filme) {
		this.nome = filme.getNome();
		this.genero = filme.getGenero();
		this.duracao = filme.getDuracao();
		this.dataLancamento = filme.getDataLancamento();
	}

	public static List<FilmeDTO> converter(List<Filme> filmes) {
		return filmes.stream().map(FilmeDTO::new).collect(Collectors.toList());
	}

}
