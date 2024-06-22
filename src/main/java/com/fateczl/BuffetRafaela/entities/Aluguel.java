package com.fateczl.BuffetRafaela.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fateczl.BuffetRafaela.records.DadosAtualizacaoAluguel;
import com.fateczl.BuffetRafaela.records.DadosCadastroAluguel;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Table(name="aluguel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aluguel_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @OneToMany(mappedBy = "aluguel", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = false)
    private List<Item> itens = new ArrayList<>();

    @Column(name = "dt_hr_inicio")
    private LocalDateTime dtHoraInicio;

    @Column(name = "dt_hr_fim")
    private LocalDateTime dtHoraFim;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "desconto")
    private Double desconto;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cep")
    private String cep;
    
    public Aluguel() {
    	
    }

    public Aluguel(DadosCadastroAluguel dados) {
        this.cliente = dados.cliente();
        this.tema = dados.tema();
        this.itens = dados.item();
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
        if (dados.itens() != null) {
            this.itens.clear();
            this.itens.addAll(dados.itens());
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

	public List<Item> getItens() {
		return itens;
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
	
    public void addItem(Item item) {
        if (this.itens == null) {
            this.itens = new ArrayList<>();
        }
        this.itens.add(item);
        item.setAluguel(this);
    }

    public void removeItem(Item item) {
        itens.remove(item);
        item.setAluguel(null);
    }

	public void setId(Long id) {
		this.id = id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void setDtHoraInicio(LocalDateTime dtHoraInicio) {
		this.dtHoraInicio = dtHoraInicio;
	}

	public void setDtHoraFim(LocalDateTime dtHoraFim) {
		this.dtHoraFim = dtHoraFim;
	}
	
	

	public void setValorTotal() {
	    double valorItens = 0.0;

	    // Somar os valores dos itens
	    for (Item item : this.itens) {
	        valorItens += item.getValorUnitario();
	    }

	    // Calcular o valor total incluindo o preço do tema
	    double desconto = this.desconto != null ? this.desconto : 0.0;
	    this.valorTotal = (valorItens + this.tema.getPreco()) * (1 - desconto);
	}



	public void setDesconto(Double desconto) {
		this.desconto = desconto != null ? desconto : 0.0;
		
		if (cliente.getAlugueis().size() >= 5 || cliente.getAlugueis().size() < 10) {
			this.desconto = 0.05;
		} if (cliente.getAlugueis().size() >= 10 || cliente.getAlugueis().size() < 20) {
			this.desconto = 0.1;
		} if (cliente.getAlugueis().size() >= 20 || cliente.getAlugueis().size() < 30) {
			this.desconto = 0.15;
		} if (cliente.getAlugueis().size() >= 30 || cliente.getAlugueis().size() < 50) {
			this.desconto = 0.2;
		} if (cliente.getAlugueis().size() >= 50) {
			this.desconto = 0.25;
		}
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
