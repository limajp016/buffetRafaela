package com.fateczl.BuffetRafaela.records;

import java.time.LocalDateTime;
import java.util.List;

import com.fateczl.BuffetRafaela.entities.Cliente;
import com.fateczl.BuffetRafaela.entities.Item;
import com.fateczl.BuffetRafaela.entities.Tema;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluguel(
        @NotNull Cliente cliente,
        @NotNull Tema tema,
        List<Item> item,
        @NotNull LocalDateTime dtHoraInicio,
        @NotNull LocalDateTime dtHoraFim,
        Double valorTotal,
        Double desconto,
        @NotNull String logradouro,
        @NotNull String numero,
        String complemento,
        @NotNull String bairro,
        @NotNull String cidade,
        @NotNull String uf,
        @NotNull String cep) {
}
