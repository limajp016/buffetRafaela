package com.fateczl.BuffetRafaela.endereco;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	Optional<Endereco> findByLogradouro(String logradouro);
	
}
