package com.fateczl.BuffetRafaela.tema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TemaService {
	@Autowired
	private TemaRepository repository;
	
	public List<Tema> getAllTema(){
		return repository.findAll(Sort.by("descricao"));
	}

}
