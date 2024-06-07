package com.fateczl.BuffetRafaela.aluguel;

import java.time.LocalDateTime;

import com.fateczl.BuffetRafaela.cliente.Cliente;
import com.fateczl.BuffetRafaela.endereco.Endereco;
import com.fateczl.BuffetRafaela.item.Item;
import com.fateczl.BuffetRafaela.tema.Tema;

public record DadosListagemAluguel(Long id,
		Cliente cliente,
		Endereco endereco,
		Tema tema,
		Item item,
		LocalDateTime dtHoraInicio,
		LocalDateTime dtHoraFim,
		Double valorTotal,
		Double desconto) {
	public DadosListagemAluguel(Aluguel aluguel) {
		this(aluguel.getId(),
				aluguel.getCliente(),
				aluguel.getEndereco(),
				aluguel.getTema(),
				aluguel.getItem(),
				aluguel.getDtHoraInicio(),
				aluguel.getDtHoraFim(),
				aluguel.getValorTotal(),
				aluguel.getDesconto());
	}

}
