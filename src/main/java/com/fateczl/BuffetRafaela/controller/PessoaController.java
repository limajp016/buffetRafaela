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

import com.fateczl.BuffetRafaela.pessoa.DadosAtualizacaoPessoa;
import com.fateczl.BuffetRafaela.pessoa.DadosCadastroPessoa;
import com.fateczl.BuffetRafaela.pessoa.Pessoa;
import com.fateczl.BuffetRafaela.pessoa.PessoaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if(id != null) {
			var pessoa = repository.getReferenceById(id);
			model.addAttribute("item", pessoa);
		}
		return "pessoa/formulario";
	}
	
	@GetMapping
	public String carregaPaginaListagem(Model model) {
		model.addAttribute("pessoa", repository.findAll(Sort.by("nome").ascending()));
		return "pessoa/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroPessoa dados) {
		repository.save(new Pessoa(dados));
		return "redirect:pessoa";
	}
	
	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoPessoa dados) {
		var pessoa = repository.getReferenceById(dados.id());
		pessoa.atualizarInformacoes(dados);
		return "redirect:pessoa";
	}
	
	@DeleteMapping
	@Transactional
	public String removePessoa(Long id) {
		repository.deleteById(id);
		return "redirect:pessoa";
	}

}
