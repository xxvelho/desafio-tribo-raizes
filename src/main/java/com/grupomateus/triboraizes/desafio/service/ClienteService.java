package com.grupomateus.triboraizes.desafio.service;

import com.grupomateus.triboraizes.desafio.dto.ClienteDto;
import com.grupomateus.triboraizes.desafio.mapper.ClienteMapper;
import com.grupomateus.triboraizes.desafio.model.Cliente;
import com.grupomateus.triboraizes.desafio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDto cadastrarCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toCliente(clienteDto);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteMapper.toClienteDto(clienteSalvo);
    }

    public ClienteDto buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            return null;
        }
        return ClienteMapper.toClienteDto(cliente);
    }

    public void deletarClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteDto atualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toCliente(clienteDto);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteMapper.toClienteDto(clienteSalvo);
    }

    public List<ClienteDto> listarTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteMapper.toClienteDtoList(clientes);
    }
}
