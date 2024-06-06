package com.fateczl.BuffetRafaela.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
		@NotNull Long id,
		@NotNull String logradouro,
		@NotNull String numero,
		String complemento,
		@NotNull String bairro,
		@NotNull String cidade,
		@NotNull String estado,
		@NotNull String cep) {

}
