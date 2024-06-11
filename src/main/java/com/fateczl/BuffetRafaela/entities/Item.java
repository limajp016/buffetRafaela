package com.fateczl.BuffetRafaela.entities;

import com.fateczl.BuffetRafaela.records.DadosAtualizacaoItem;
import com.fateczl.BuffetRafaela.records.DadosCadastroItem;

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

@Table(name ="item")
@Entity(name ="item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Item {	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Long id;
	@Column(name="descricao")
	private String descricao;
	@Column(name="valor_unitario")
	private Double valorUnitario;
	
	public Item() {
		
	}
	
	public Item(Long id) {
		this.id = id;
	}
	
	public Item(DadosCadastroItem dados) {
		this.descricao = dados.descricao();
		this.valorUnitario = dados.valorUnitario();
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoItem dados) {
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if (dados.valorUnitario() != null) {
			this.valorUnitario = dados.valorUnitario();
		}
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}


}
