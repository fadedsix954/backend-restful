package com.atividade9.backend_restful.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atividade9.backend_restful.model.Produto;
import com.atividade9.backend_restful.service.ProdutoService;

@RestController
@RequestMapping("/produtos")  // Define o caminho base para os endpoints de Produto
public class ProdutoController {

    private final ProdutoService produtoService;

    // Injeção de dependência do ProdutoService
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Endpoint para salvar um novo produto
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    // Endpoint para listar todos os produtos
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    // Endpoint para buscar um produto pelo ID
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    // Endpoint para buscar produtos por nome
    @GetMapping("/buscar-por-nome")
    public List<Produto> buscarPorNome(@RequestParam String nome) {
        return produtoService.buscarPorNome(nome);
    }
}
