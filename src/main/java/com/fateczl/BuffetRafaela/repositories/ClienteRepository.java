package com.fateczl.BuffetRafaela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fateczl.BuffetRafaela.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
}
