package com.fateczl.BuffetRafaela.cliente;

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

@Table(name="cliente")
@Entity(name="cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Cliente {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cliente_id")
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
	
	public Cliente() {
		
	}
	
	public Cliente(DadosCadastroCliente dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.clienteAntigo = dados.clienteAntigo();
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoCliente dados) {
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

	public boolean isClienteAntigo() {
		return clienteAntigo;
	}
	
}
