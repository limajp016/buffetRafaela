package com.fateczl.BuffetRafaela.pessoa;

public record DadosListagemPessoa(
		Long id,
		String nome) {
	public DadosListagemPessoa(Pessoa pessoa) {
		this(pessoa.getId(),
				pessoa.getNome());
	}

}
