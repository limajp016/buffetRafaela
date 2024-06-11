package com.fateczl.BuffetRafaela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fateczl.BuffetRafaela.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
}
