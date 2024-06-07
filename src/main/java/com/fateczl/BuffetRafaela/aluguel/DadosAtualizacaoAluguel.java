package com.fateczl.BuffetRafaela.aluguel;

import java.time.LocalDateTime;

import com.fateczl.BuffetRafaela.cliente.Cliente;
import com.fateczl.BuffetRafaela.endereco.Endereco;
import com.fateczl.BuffetRafaela.item.Item;
import com.fateczl.BuffetRafaela.tema.Tema;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluguel(
		@NotNull
		Long id,
		Cliente cliente,
		Endereco endereco,
		Tema tema,
		Item item,
		LocalDateTime dtHoraInicio,
		LocalDateTime dtHoraFim,
		Double valorTotal,
		Double desconto) {

}
