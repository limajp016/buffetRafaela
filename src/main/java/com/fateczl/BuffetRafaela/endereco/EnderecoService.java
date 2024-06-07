package com.fateczl.BuffetRafaela.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> getAllEndereco(){
		return repository.findAll(Sort.by("logradouro"));
	}
	
	public Endereco getItemByEndereco(Long id) {
		return repository.getReferenceById(id);
	} 

}
