package com.fateczl.BuffetRafaela.tema;

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
