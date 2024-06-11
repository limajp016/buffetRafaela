package com.fateczl.BuffetRafaela.records;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoItem(
		@NotNull Long id,
		@NotNull String descricao,
		@NotNull Double valorUnitario
		) {

}
