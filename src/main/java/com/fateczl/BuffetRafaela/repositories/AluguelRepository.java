package com.fateczl.BuffetRafaela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fateczl.BuffetRafaela.entities.Aluguel;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    long countByClienteId(Long clienteId);

    @Query("SELECT COUNT(a) FROM aluguel a WHERE a.cliente.id = :clienteId")
    long countAlugueisByClienteId(@Param("clienteId") Long clienteId);
	
}
