package org.example.Controller;

import org.example.Models.ClienteRequest;
import org.example.Models.Endereco;
import org.example.Service.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;

import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Rota: GET /clientes/listar
     * Objetivo: Mostrar a página com a lista de todos os clientes.
     */

    @GetMapping("/listar")
    public String listarClientes(Model model) {
        model.addAttribute("listaClientes", clienteRepository.findAll());

        return "ListaClientes";
    }

    /**
     * Rota: GET /clientes/novo
     * Objetivo: Mostrar o formulário em branco para criar um novo cliente.
     */

    @GetMapping("/novo")
    public String mostrarFormularioNovo(Model model) {
        ClienteRequest cliente = new ClienteRequest();

        cliente.setEndereco(new Endereco());

        model.addAttribute("cliente", cliente);

        return "FormsCliente";
    }

    /**
     * Rota: POST /clientes/salvar
     * Objetivo: Receber os dados do formulário (novo ou edição) e salvar no banco.
     */

    @PostMapping("/salvar")
    public String salvarCliente(@Valid ClienteRequest cliente, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("mensagemErro", "Corrija os erros abaixo.");
            return "FormsCliente";
        }

        clienteRepository.save(cliente);

        return "redirect:/clientes/listar";
    }

    /**
     * Rota: GET /clientes/editar/{id}
     * Objetivo: Mostrar o formulário preenchido com dados de um cliente para edição.
     * Ex: /clientes/editar/5
     */

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {

        Optional<ClienteRequest> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()) {
            model.addAttribute("cliente", clienteOptional.get());
            return "FormsCliente";
        } else {
            return "redirect:/clientes/listar";
        }
    }

    /**
     * Rota: GET /clientes/deletar/{id}
     * Objetivo: Deletar um cliente pelo ID.
     * Ex: /clientes/deletar/5
     */

    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable("id") Long id) {
        try {
            clienteRepository.deleteById(id);
        } catch (Exception e) {
        }
        return "redirect:/clientes/listar";
    }
}