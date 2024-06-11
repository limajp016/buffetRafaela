package com.fateczl.BuffetRafaela.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fateczl.BuffetRafaela.records.DadosAtualizacaoAluguel;
import com.fateczl.BuffetRafaela.records.DadosCadastroAluguel;
import com.fateczl.BuffetRafaela.services.AluguelService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="aluguel")
@Entity(name ="aluguel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Aluguel {
	
	@Transient
    @Autowired
    private AluguelService aluguelService;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="aluguel_id")
    private Long id;
	@ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
	@ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;
	@ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
	@Column(name="dt_hr_inicio")
	private LocalDateTime dtHoraInicio;
	@Column(name="dt_hr_fim")
	private LocalDateTime dtHoraFim;
	@Column(name="valor_total")
	private Double valorTotal;
	@Column(name="desconto")
	private Double desconto;
	@Column(name="logradouro")
	private String logradouro;
	@Column(name="numero")
	private String numero;
	@Column(name="complemento")
	private String complemento;
	@Column(name="bairro")
	private String bairro;
	@Column(name="cidade")
	private String cidade;
	@Column(name="uf")
	private String uf;
	@Column(name="cep")
	private String cep;
	
	public Aluguel() {
		
	}
	
	public Aluguel(DadosCadastroAluguel dados) {
		this.cliente = dados.cliente();
		this.tema = dados.tema();
		this.item = dados.item();
		this.dtHoraInicio = dados.dtHoraInicio();
		this.dtHoraFim = dados.dtHoraFim();
		this.valorTotal = dados.valorTotal();
		this.desconto = dados.desconto();
		this.logradouro = dados.logradouro();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
		this.bairro = dados.bairro();
		this.cidade = dados.cidade();
		this.uf = dados.uf();
		this.cep = dados.cep();
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoAluguel dados) {
		if (dados.cliente() != null) {
			this.cliente = dados.cliente();
		}
		if (dados.tema() != null) {
			this.tema = dados.tema();
		}
		if (dados.item() != null) {
			this.item = dados.item();
		}
		if (dados.dtHoraInicio() != null) {
			this.dtHoraInicio = dados.dtHoraInicio();
		}
		if (dados.dtHoraFim() != null) {
			this.dtHoraFim = dados.dtHoraFim();
		}
		if (dados.valorTotal() != null) {
			this.valorTotal = dados.valorTotal();
		}
		if (dados.desconto() != null) {
			this.desconto = dados.desconto();
		}
		if (dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}
		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
		if (dados.bairro() != null) {
			this.bairro = dados.bairro();
		}
		if (dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		if (dados.uf() != null) {
			this.uf = dados.uf();
		}
		if (dados.cep() != null) {
			this.cep = dados.cep();
		}
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Tema getTema() {
		return tema;
	}

	public Item getItem() {
		return item;
	}

	public LocalDateTime getDtHoraInicio() {
		return dtHoraInicio;
	}

	public LocalDateTime getDtHoraFim() {
		return dtHoraFim;
	}

	public Double getValorTotal() {
		List<Item> itens = new ArrayList<>();
		double valorItens = 0.0;
		for (Item i : itens) {
			valorItens += i.getValorUnitario();
		}
		valorTotal = valorItens + tema.getPreco();
		
		if (cliente != null && aluguelService != null) {
			double descontoCliente = aluguelService.calcularDesconto(cliente.getId());
            valorTotal = valorTotal * (1 - descontoCliente);
        }
		
		return valorTotal;
	}

	public Double getDesconto() {
		return desconto;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}

	
}
