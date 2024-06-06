package com.fateczl.BuffetRafaela.pessoa;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(
		@NotNull String nome,
		@NotNull String cpf,
		@NotNull String telefone,
		@NotNull String email,
		boolean clienteAntigo) {
	
}
