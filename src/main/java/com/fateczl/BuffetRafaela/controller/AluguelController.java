package com.fateczl.BuffetRafaela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.fateczl.BuffetRafaela.aluguel.Aluguel;
import com.fateczl.BuffetRafaela.aluguel.AluguelRepository;
import com.fateczl.BuffetRafaela.aluguel.DadosAtualizacaoAluguel;
import com.fateczl.BuffetRafaela.aluguel.DadosCadastroAluguel;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

public class AluguelController {
	
	@Autowired
	private AluguelRepository repository;
	
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if(id != null) {
			var aluguel = repository.getReferenceById(id);
			model.addAttribute("aluguel", aluguel);
		}
		return "aluguel/formulario";
	}
	
	@GetMapping
	public String carregaPaginaListagem(Model model) {
		model.addAttribute("aluguel", repository.findAll(Sort.by("aluguel").ascending()));
		return "aluguel/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroAluguel dados) {
		repository.save(new Aluguel(dados));
		return "redirect:aluguel";
	}
	
	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoAluguel dados) {
		var aluguel = repository.getReferenceById(dados.id());
		aluguel.atualizarInformacoes(dados);
		return "redirect:aluguel";
	}
	
	@DeleteMapping
	@Transactional
	public String removeAluguel(Long id) {
		repository.deleteById(id);
		return "redirect:aluguel";
	}

}