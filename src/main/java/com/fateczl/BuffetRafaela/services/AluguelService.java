package com.fateczl.BuffetRafaela.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fateczl.BuffetRafaela.entities.Aluguel;
import com.fateczl.BuffetRafaela.repositories.AluguelRepository;

@Service
public class AluguelService {
	@Autowired
	private AluguelRepository repository;

	public List<Aluguel> getAllAluguel() {
        return repository.findAll(Sort.by("id"));
    }
	
	public Aluguel getAluguelById(Long id) {
		return repository.getReferenceById(id);
	}
	
	public Double calcularDesconto(Long clienteId) {
		double numeroDeAlugueis = repository.countByClienteId(clienteId);
        double desconto = 0.0;

        if (numeroDeAlugueis > 5) {
            desconto = 0.025;
        } else if (numeroDeAlugueis > 10) {
            desconto = 0.05; 
        } else if (numeroDeAlugueis > 15) {
        	desconto = 0.075;
        } else if (numeroDeAlugueis > 20) {
        	desconto = 0.10;
        } else if (numeroDeAlugueis >= 20) {
        	desconto = 0.15;
        }
        
        return desconto;
	}
	
    public List<Aluguel> getAlugueisPorCliente(Long clienteId) {
        return repository.findAllByClienteId(clienteId);
    }
    
    public List<Aluguel> getAlugueisPorItem(Long temaId) {
        return repository.findAllByTemaId(temaId);
    }
}
