package com.fateczl.BuffetRafaela.entities;

import java.util.ArrayList;
import java.util.List;

import com.fateczl.BuffetRafaela.records.DadosAtualizacaoCliente;
import com.fateczl.BuffetRafaela.records.DadosCadastroCliente;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aluguel> alugueis = new ArrayList<>();
	
	public Cliente() {
		
	}
	
	public Cliente(DadosCadastroCliente dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.telefone = dados.telefone();
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
	
	public List<Aluguel> getAlugueis() {
        return alugueis;
    }
	
}
