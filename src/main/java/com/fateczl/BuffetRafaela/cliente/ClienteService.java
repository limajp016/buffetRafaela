package com.fateczl.BuffetRafaela.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> getAllCliente(){
		return repository.findAll(Sort.by("nome"));
	}
	
	public Cliente getPessoaById(Long id) {
		return repository.getReferenceById(id);
	}

}
