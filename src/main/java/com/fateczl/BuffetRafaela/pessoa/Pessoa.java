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
	@Column(name="cliente_antigo")
	private boolean clienteAntigo = false;
	
	public Pessoa() {
		
	}
	
	public Pessoa(DadosCadastroPessoa dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.clienteAntigo = dados.clienteAntigo();
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoPessoa dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.cpf() != null) {
			this.cpf = dados.cpf();
		}
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
	}
	
	public void registrarPrimeiroAluguel() {
		this.clienteAntigo = true;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
	
}
