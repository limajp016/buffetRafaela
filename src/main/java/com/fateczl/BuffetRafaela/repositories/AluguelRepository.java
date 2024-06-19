package com.fateczl.BuffetRafaela.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fateczl.BuffetRafaela.entities.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    
    long countByClienteId(Long clienteId);

    @Query("SELECT COUNT(a) FROM Aluguel a WHERE a.cliente.id = :clienteId")
    long countAluguelByClienteId(@Param("clienteId") Long clienteId);

    @Query("SELECT a FROM Aluguel a WHERE a.cliente.id = :clienteId")
    List<Aluguel> findAllByClienteId(@Param("clienteId") Long clienteId);

    @Query("SELECT a FROM Aluguel a WHERE a.tema.id = :temaId")
    List<Aluguel> findAllByTemaId(@Param("temaId") Long temaId);
}
