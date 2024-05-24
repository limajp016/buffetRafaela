package com.fateczl.BuffetRafaela.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

public class ItemService {
	@Autowired
	private ItemRepository repository;

	public List<Item> getAllItem(){
		return repository.findAll(Sort.by("descricao"));
	}
	
	public Item getItemById(Long id) {
		return repository.getReferenceById(id);
	}
	
}
