package com.fateczl.BuffetRafaela.records;

import java.time.LocalDateTime;
import java.util.List;

import com.fateczl.BuffetRafaela.entities.Aluguel;
import com.fateczl.BuffetRafaela.entities.Cliente;
import com.fateczl.BuffetRafaela.entities.Item;
import com.fateczl.BuffetRafaela.entities.Tema;

public record DadosListagemAluguel(
        Long id,
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
    public DadosListagemAluguel(Aluguel aluguel) {
        this(aluguel.getId(),
                aluguel.getCliente(),
                aluguel.getTema(),
                aluguel.getItens(),
                aluguel.getDtHoraInicio(),
                aluguel.getDtHoraFim(),
                aluguel.getValorTotal(),
                aluguel.getDesconto(),
                aluguel.getLogradouro(),
                aluguel.getNumero(),
                aluguel.getComplemento(),
                aluguel.getBairro(),
                aluguel.getCidade(),
                aluguel.getUf(),
                aluguel.getCep());
    }
}