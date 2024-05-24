package com.fateczl.BuffetRafaela.item;

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
