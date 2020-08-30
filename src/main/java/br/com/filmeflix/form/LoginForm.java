package br.com.filmeflix.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Setter;

@Setter
public class LoginForm {
	private String usuario;
	private String senha;

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(usuario, senha);
	}
}
