package com.fateczl.BuffetRafaela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fateczl.BuffetRafaela.entities.Aluguel;
import com.fateczl.BuffetRafaela.repositories.AluguelRepository;
import com.fateczl.BuffetRafaela.repositories.ClienteRepository;
import com.fateczl.BuffetRafaela.repositories.TemaRepository;
import com.fateczl.BuffetRafaela.repositories.ItemRepository;
import com.fateczl.BuffetRafaela.records.DadosAtualizacaoAluguel;
import com.fateczl.BuffetRafaela.records.DadosCadastroAluguel;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            var aluguel = aluguelRepository.getReferenceById(id);
            model.addAttribute("aluguel", aluguel);
        }
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("temas", temaRepository.findAll());
        model.addAttribute("itens", itemRepository.findAll());
        return "aluguel/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("alugueis", aluguelRepository.findAll(Sort.by("dtHoraInicio").ascending()));
        return "aluguel/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastrar(@Valid DadosCadastroAluguel dados) {
        aluguelRepository.save(new Aluguel(dados));
        return "redirect:/aluguel";
    }

    @PutMapping
    @Transactional
    public String atualizar(@Valid DadosAtualizacaoAluguel dados) {
        var aluguel = aluguelRepository.getReferenceById(dados.id());
        aluguel.atualizarInformacoes(dados);
        return "redirect:/aluguel";
    }

    @DeleteMapping
    @Transactional
    public String removeAluguel(@RequestParam Long id) {
        aluguelRepository.deleteById(id);
        return "redirect:/aluguel";
    }
    
    @PostMapping("/submitAluguel")
    @Transactional
    public String submitAluguel(@RequestParam List<Long> itens, Model model) {
        Aluguel aluguel = new Aluguel();
             
        for (Long itemId : itens) {
            var item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + itemId));
            aluguel.addItem(item);
        }
        
        aluguelRepository.save(aluguel);
     
        model.addAttribute("message", "Pedido submetido com sucesso!");
        return "redirect:/aluguel";
    }
}
