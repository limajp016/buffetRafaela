package com.fateczl.BuffetRafaela.aluguel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}
