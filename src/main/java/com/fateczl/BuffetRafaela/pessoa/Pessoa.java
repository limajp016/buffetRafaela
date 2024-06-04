package com.fateczl.BuffetRafaela.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="pessoa")
@Entity(name="pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Pessoa {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Long id;
	@Column(name="nome")
	private String nome;
	@Column(name="cpf")
	private String cpf;
	@Column(name="telefone")
	private String telefone;
	@Column(name="email")
	private String email;
	
	public Pessoa() {
		
	}
	
	public Pessoa(Long id) {
		this.id = id;
	}
	
	public Pessoa(DadosCadastroPessoa dados) {
		this.nome = dados.nome();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoPessoa dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
	}
}
