package com.fateczl.BuffetRafaela.endereco;

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

@Table(name="endereco")
@Entity(name ="endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Endereco {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="endereco_id")
    private Long id;
	@Column(name="logradouro")
	private String logradouro;
	@Column(name="numero")
	private String numero;
	@Column(name="complemento")
	private String complemento;
	@Column(name="bairro")
	private String bairro;
	@Column(name="cidade")
	private String cidade;
	@Column(name="estado")
	private String estado;
	@Column(name="cep")
	private String cep;
	
	public Endereco() {
		
	}
	
	public Endereco(DadosCadastroEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.estado = dados.estado();
        this.cep = dados.cep();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.estado() != null) {
            this.estado = dados.estado();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
    }

	public Long getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

}
