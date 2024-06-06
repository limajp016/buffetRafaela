package com.fateczl.BuffetRafaela.pessoa;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(
		@NotNull
		Long id,
		String nome,
		String cpf,
		String telefone,
		String email,
		boolean clienteAntigo) {

}
