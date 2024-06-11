package com.fateczl.BuffetRafaela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fateczl.BuffetRafaela.entities.Item;
import com.fateczl.BuffetRafaela.records.DadosAtualizacaoItem;
import com.fateczl.BuffetRafaela.records.DadosCadastroItem;
import com.fateczl.BuffetRafaela.repositories.ItemRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository repository;
	
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if(id != null) {
			var item = repository.getReferenceById(id);
			model.addAttribute("item", item);
		}
		return "item/formulario";
	}
	
	@GetMapping
	public String carregaPaginaListagem(Model model) {
		model.addAttribute("item", repository.findAll(Sort.by("descricao").ascending()));
		return "item/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroItem dados) {
		repository.save(new Item(dados));
		return "redirect:item";
	}
	
	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoItem dados) {
		var item = repository.getReferenceById(dados.id());
		item.atualizarInformacoes(dados);
		return "redirect:item";
	}
	
	@DeleteMapping
	@Transactional
	public String removeItem(Long id) {
		repository.deleteById(id);
		return "redirect:item";
	}
}
