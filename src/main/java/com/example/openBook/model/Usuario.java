package com.example.openBook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tb_usuario")

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "o campo é obrigatório!")
	@Size(min =3,  message = "O campo deve ter entre 3 e 255 caracteres")
	private String nome;
	
	@NotBlank(message = "o campo é obrigatório!")
	@Email(message = "O campo deve ter entre 3 e 255 caracteres")
	private String usuario;
	
	@NotBlank(message = "o campo é obrigatório!")
	@Size(min =8, message = "O campo deve possuir um valor valido (10 ou 13 caracteres)")
	private String senha;

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

	public String getusuario() {
		return usuario;
	}

	public void setusuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario(Long id, String nome, String usuario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario() {
	}

}
