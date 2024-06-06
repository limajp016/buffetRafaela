package com.fateczl.BuffetRafaela.item;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroItem(
		@NotNull String descricao,
		@NotNull Double valorUnitario) {

}
