package com.fateczl.BuffetRafaela.records;

import com.fateczl.BuffetRafaela.entities.Item;

public record DadosListagemItem(
		Long id,
		String descricao,
		Double valorUnitario) {
	
	public DadosListagemItem(Item item) {
		this(item.getId(), 
				item.getDescricao(), 
				item.getValorUnitario());
	}

}
