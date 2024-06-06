package com.fateczl.BuffetRafaela.pessoa;

public record DadosListagemPessoa(
		Long id,
		String nome,
		String cpf,
		String email,
		String telefone) {
	public DadosListagemPessoa(Pessoa pessoa) {
		this(pessoa.getId(),
				pessoa.getNome(),
				pessoa.getCpf(),
				pessoa.getEmail(),
				pessoa.getTelefone());
	}

}
