package com.fateczl.BuffetRafaela.records;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroItem(
		@NotNull String descricao,
		@NotNull Double valorUnitario) {

}
