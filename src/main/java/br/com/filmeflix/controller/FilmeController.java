package br.com.filmeflix.controller;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.filmeflix.dto.FilmeDTO;
import br.com.filmeflix.model.Filme;
import br.com.filmeflix.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	FilmeRepository filmeRepository;
	
	@GetMapping
	public List<FilmeDTO> listar(Long id) {
		List<Filme> filmes = new LinkedList<Filme>();
		filmes = filmeRepository.findTop10ByOrderByDataInsercaoDesc();
		
		return FilmeDTO.converter(filmes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filme> detalhar(@PathVariable Long id) {
		Optional<Filme> filme = filmeRepository.findById(id);
		if (filme.isPresent()) {
			return ResponseEntity.ok(new Filme(filme.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<FilmeDTO> inserir(@RequestBody Filme filme, UriComponentsBuilder uriBuilder) {
		filmeRepository.save(filme);
		
		URI uri = uriBuilder.path("/filmes/{id}").buildAndExpand(filme.getId()).toUri();
		return ResponseEntity.created(uri).body(new FilmeDTO(filme));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Filme> optional = filmeRepository.findById(id);
		if (optional.isPresent()) {
			filmeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
		
	}
}
