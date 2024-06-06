package com.fateczl.BuffetRafaela.tema;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroTema(
		@NotNull String descricao,
		@NotNull Double preco) {

}
