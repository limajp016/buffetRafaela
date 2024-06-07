package com.fateczl.BuffetRafaela.aluguel;

import java.time.LocalDateTime;

import com.fateczl.BuffetRafaela.cliente.Cliente;
import com.fateczl.BuffetRafaela.endereco.Endereco;
import com.fateczl.BuffetRafaela.item.Item;
import com.fateczl.BuffetRafaela.tema.Tema;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluguel(
		@NotNull Cliente cliente,
		@NotNull Endereco endereco,
		@NotNull Tema tema,
		@NotNull Item item,
		@NotNull LocalDateTime dtHoraInicio,
		@NotNull LocalDateTime dtHoraFim,
		@NotNull Double valorTotal,
		@NotNull Double desconto) {

}
