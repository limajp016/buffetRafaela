package com.fateczl.BuffetRafaela.records;

import com.fateczl.BuffetRafaela.entities.Tema;

public record DadosListagemTema(
		Long id,
		String descricao,
		Double preco) {
	public DadosListagemTema(Tema tema) {
		this(tema.getId(),
				tema.getDescricao(),
				tema.getPreco());
	}

}
