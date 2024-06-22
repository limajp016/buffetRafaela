package com.fateczl.BuffetRafaela.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fateczl.BuffetRafaela.entities.Aluguel;
import com.fateczl.BuffetRafaela.entities.Item;
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
        model.addAttribute("alugueis", aluguelRepository.findAll(Sort.by("id")));
        return "aluguel/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastrar(@RequestParam Long clienteId,
                            @RequestParam Long temaId,
                            @RequestParam List<Long> itens,
                            @Valid DadosCadastroAluguel dados) {
        var cliente = clienteRepository.findById(clienteId)
                                        .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        var tema = temaRepository.findById(temaId)
                                .orElseThrow(() -> new IllegalArgumentException("Tema não encontrado"));
        var aluguel = new Aluguel(dados);
        aluguel.setCliente(cliente);
        aluguel.setTema(tema);
        
        for (Long itemId : itens) {
            var item = itemRepository.findById(itemId)
                                    .orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + itemId));
            aluguel.addItem(item);
        }

        aluguel.setValorTotal();
        
        aluguelRepository.save(aluguel);
        return "redirect:/aluguel";
    }

    @PutMapping
    @Transactional
    public String atualizar(@RequestParam Long id,
                            @RequestParam Long clienteId,
                            @RequestParam Long temaId,
                            @RequestParam List<Long> itens,
                            @Valid DadosAtualizacaoAluguel dados) {
        var aluguel = aluguelRepository.findById(id)
                                       .orElseThrow(() -> new IllegalArgumentException("Aluguel não encontrado"));
        var cliente = clienteRepository.findById(clienteId)
                                       .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        var tema = temaRepository.findById(temaId)
                                 .orElseThrow(() -> new IllegalArgumentException("Tema não encontrado"));
        
        aluguel.setCliente(cliente);
        aluguel.setTema(tema);
        aluguel.atualizarInformacoes(dados);

        // Atualizando os itens do aluguel
        for (Long itemId : itens) {
            var item = itemRepository.findById(itemId)
                                     .orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + itemId));
            aluguel.addItem(item);
        }

        aluguel.setValorTotal();
        
        aluguelRepository.save(aluguel);
        return "redirect:/aluguel";
    }


    @DeleteMapping
    @Transactional
    public String removeAluguel(@RequestParam Long id) {
		var aluguel = aluguelRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Aluguel não encontrado"));
		
		
		for (Item item : aluguel.getItens()) {
			item.setAluguel(null);
		}
        
		aluguelRepository.deleteById(id);
        return "redirect:/aluguel";
    }

    @PostMapping("/submitAluguel")
    @Transactional
    public String submitAluguel(@RequestParam List<Long> itens, Model model) {
        Aluguel aluguel = new Aluguel();
        aluguel.setItens(new ArrayList<>());

        for (Long itemId : itens) {
            var item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("Item não encontrado: " + itemId));
            aluguel.addItem(item);
        }

        aluguelRepository.save(aluguel);

        model.addAttribute("message", "Pedido submetido com sucesso!");
        return "redirect:/aluguel";
    }

}
