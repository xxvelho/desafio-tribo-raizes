package com.grupomateus.triboraizes.desafio.controller;

import com.grupomateus.triboraizes.desafio.model.Produto;
import com.grupomateus.triboraizes.desafio.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque/produtos")
public class ProdutoController {
    private ProdutoService produtoService;
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/cadastrar")
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable("id") Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarProdutoPorId(@PathVariable("id") Long id) {
        produtoService.deletarProdutoPorId(id);
    }

    @PutMapping("/atualizar")
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return produtoService.atualizarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }
}
