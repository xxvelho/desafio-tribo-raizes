package com.grupomateus.triboraizes.desafio.controller;

import com.grupomateus.triboraizes.desafio.dto.ClienteDto;
import com.grupomateus.triboraizes.desafio.dto.ProdutoDto;
import com.grupomateus.triboraizes.desafio.service.ClienteService;
import com.grupomateus.triboraizes.desafio.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ClienteDto cadastrarCliente(@RequestBody ClienteDto clienteDto) {
        return service.cadastrarCliente(clienteDto);
    }

    @GetMapping("/{id}")
    public ClienteDto buscarClientePorId(@PathVariable("id") Long id) {
        return service.buscarClientePorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarClientePorId(@PathVariable("id") Long id) {
        service.deletarClientePorId(id);
    }

    @PutMapping("/atualizar")
    public ClienteDto atualizarCliente(@RequestBody ClienteDto clienteDto) {
        return service.atualizarCliente(clienteDto);
    }

    @GetMapping("/listar")
    public List<ClienteDto> listarTodosClientes() {
        return service.listarTodosClientes();
    }
}
