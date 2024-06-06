package com.fateczl.BuffetRafaela.endereco;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;

public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> getAllEndereco(){
		return repository.findAll(Sort.by("logradouro"));
	}
	
	public Endereco getItemByEndereco(Long id) {
		return repository.getReferenceById(id);
	} 
	
	public Endereco getEnderecoByLogradouro(@PathVariable String logradouro) {
		Optional<Endereco> enderecoOpt = repository.findByLogradouro(logradouro);
		return enderecoOpt.orElse(null);
    }

}
