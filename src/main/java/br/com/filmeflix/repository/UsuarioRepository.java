package br.com.filmeflix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filmeflix.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsuario(String usuario);
}
