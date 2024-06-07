package com.fateczl.BuffetRafaela.cliente;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
		@NotNull String nome,
		@NotNull String cpf,
		@NotNull String telefone,
		@NotNull String email,
		boolean clienteAntigo) {
	
}
