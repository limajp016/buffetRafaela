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

import com.fateczl.BuffetRafaela.endereco.DadosAtualizacaoEndereco;
import com.fateczl.BuffetRafaela.endereco.DadosCadastroEndereco;
import com.fateczl.BuffetRafaela.endereco.Endereco;
import com.fateczl.BuffetRafaela.endereco.EnderecoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if(id != null) {
			var endereco = repository.getReferenceById(id);
			model.addAttribute("endereco", endereco);
		}
		return "endereco/formulario";
	}
	
	@GetMapping
	public String carregaPaginaListagem(Model model) {
		model.addAttribute("endereco", repository.findAll(Sort.by("logradouro").ascending()));
		return "endereco/listagem";
	}
	
	@PostMapping
	@Transactional
	public String cadastrar(@Valid DadosCadastroEndereco dados) {
		repository.save(new Endereco(dados));
		return "redirect:endereco";
	}
	
	@PutMapping
	@Transactional
	public String atualizar(@Valid DadosAtualizacaoEndereco dados) {
		var endereco = repository.getReferenceById(dados.id());
		endereco.atualizarInformacoes(dados);
		return "redirect:endereco";
	}
	
	@DeleteMapping
	@Transactional
	public String removeEndereco(Long id) {
		repository.deleteById(id);
		return "redirect:endereco";
	}

}
