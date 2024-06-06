package com.fateczl.BuffetRafaela.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroEndereco(
		@NotNull String logradouro,
		@NotNull String numero,
		String complemento,
		@NotNull String bairro,
		@NotNull String cidade,
		@NotNull String estado,
		@NotNull String cep) {

}
