package com.fateczl.BuffetRafaela.pessoa;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(
		@NotNull
		String nome,
		String cpf,
		String telefone,
		String email) {

}
