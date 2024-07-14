package com.grupomateus.triboraizes.desafio.service;

import com.grupomateus.triboraizes.desafio.dto.ProdutoDto;
import com.grupomateus.triboraizes.desafio.mapper.ProdutoMapper;
import com.grupomateus.triboraizes.desafio.model.Produto;
import com.grupomateus.triboraizes.desafio.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoDto cadastrarProduto(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.toProduto(produtoDto);
        Produto produtoSalvo = produtoRepository.save(produto);
        return ProdutoMapper.toProdutoDto(produtoSalvo);
    }

    public ProdutoDto buscarProdutoPorId(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto == null) {
            return null;
        }
        return ProdutoMapper.toProdutoDto(produto);
    }

    public void deletarProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoDto atualizarProduto(ProdutoDto produtoDto) {
        Produto produto = ProdutoMapper.toProduto(produtoDto);
        Produto produtoSalvo = produtoRepository.save(produto);
        return ProdutoMapper.toProdutoDto(produtoSalvo);
    }

    public List<ProdutoDto> listarTodosProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return ProdutoMapper.toProdutoDtoList(produtos);
    }
}
