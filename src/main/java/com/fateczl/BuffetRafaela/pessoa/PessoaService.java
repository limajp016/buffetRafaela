package com.fateczl.BuffetRafaela.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class PessoaService {
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> getAllPessoa(){
		return repository.findAll(Sort.by("nome"));
	}
	
	public Pessoa getPessoaById(Long id) {
		return repository.getReferenceById(id);
	}

}
