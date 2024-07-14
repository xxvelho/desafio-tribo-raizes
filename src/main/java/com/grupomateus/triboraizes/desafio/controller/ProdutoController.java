package com.grupomateus.triboraizes.desafio.controller;

import com.grupomateus.triboraizes.desafio.dto.ProdutoDto;
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
    public ProdutoDto cadastrarProduto(@RequestBody ProdutoDto produtoDto) {
        return produtoService.cadastrarProduto(produtoDto);
    }

    @GetMapping("/{id}")
    public ProdutoDto buscarProdutoPorId(@PathVariable("id") Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarProdutoPorId(@PathVariable("id") Long id) {
        produtoService.deletarProdutoPorId(id);
    }

    @PutMapping("/atualizar")
    public ProdutoDto atualizarProduto(@RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizarProduto(produtoDto);
    }

    @GetMapping
    public List<ProdutoDto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }
}
