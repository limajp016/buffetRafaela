package com.fateczl.BuffetRafaela.records;

import java.time.LocalDateTime;
import java.util.List;

import com.fateczl.BuffetRafaela.entities.Cliente;
import com.fateczl.BuffetRafaela.entities.Item;
import com.fateczl.BuffetRafaela.entities.Tema;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluguel(
        @NotNull Long id,
        Cliente cliente,
        Tema tema,
        List<Item> itens,
        LocalDateTime dtHoraInicio,
        LocalDateTime dtHoraFim,
        Double valorTotal,
        Double desconto,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep) {
}

