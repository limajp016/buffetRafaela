package com.fateczl.BuffetRafaela.entities;

import com.fateczl.BuffetRafaela.records.DadosAtualizacaoItem;
import com.fateczl.BuffetRafaela.records.DadosCadastroItem;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "item")
@EqualsAndHashCode(of = "id")
public class Item {    

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    
    @ManyToOne
    @JoinColumn(name = "aluguel_id")
    private Aluguel aluguel;

    public Item() {
    }

    public Item(Long id, String descricao, Double valorUnitario, Aluguel aluguel) {
        this.id = id;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.aluguel = aluguel;
    }

    public Item(DadosCadastroItem dados) {
        this.descricao = dados.descricao();
        this.valorUnitario = dados.valorUnitario();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoItem dados) {
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.valorUnitario() != null) {
            this.valorUnitario = dados.valorUnitario();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}