package com.fateczl.BuffetRafaela.aluguel;

import java.time.LocalDateTime;

import com.fateczl.BuffetRafaela.cliente.Cliente;
import com.fateczl.BuffetRafaela.endereco.Endereco;
import com.fateczl.BuffetRafaela.item.Item;
import com.fateczl.BuffetRafaela.tema.Tema;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="aluguel_id")
    private Long id;
	@ManyToOne
    @JoinColumn(name = "cliente_id")
	@Column(name="cliente")
    private Cliente cliente;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	@Column(name="endereco")
	private Endereco endereco;
	@ManyToOne
    @JoinColumn(name = "tema_id")
	@Column(name="tema")
    private Tema tema;
	@ManyToOne
    @JoinColumn(name = "item_id")
	@Column(name="item")
    private Item item;
	@Column(name="dt_hr_inicio")
	private LocalDateTime dtHoraInicio;
	@Column(name="dt_hr_fim")
	private LocalDateTime dtHoraFim;
	@Column(name="valor_total")
	private Double valorTotal;
	@Column(name="desconto")
	private Double desconto;
	
	public Aluguel() {
		
	}
	
	public Aluguel(DadosCadastroAluguel dados) {
		this.cliente = dados.cliente();
		this.endereco = dados.endereco();
		this.tema = dados.tema();
		this.item = dados.item();
		this.dtHoraInicio = dados.dtHoraInicio();
		this.dtHoraFim = dados.dtHoraFim();
		this.valorTotal = dados.valorTotal();
		this.desconto = dados.desconto();
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoAluguel dados) {
		if (dados.cliente() != null) {
			this.cliente = dados.cliente();
		}
		if (dados.endereco() != null) {
			this.endereco = dados.endereco();
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
	}
	
	public void darDescontoParaClienteAntigo() {
		if (cliente.isClienteAntigo() == true) {
			valorTotal -= desconto;
		}
	}
	
	public void calcularValorTotal() {
		
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Endereco getEndereco() {
		return endereco;
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
		return valorTotal;
	}

	public Double getDesconto() {
		return desconto;
	}
	
}
