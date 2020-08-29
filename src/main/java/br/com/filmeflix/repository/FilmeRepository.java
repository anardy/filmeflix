package br.com.filmeflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filmeflix.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	List<Filme> findTop10ByOrderByDataInsercaoDesc();
}
