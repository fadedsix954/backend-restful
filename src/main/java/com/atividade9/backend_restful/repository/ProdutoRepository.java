package com.atividade9.backend_restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade9.backend_restful.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Busca personalizada para encontrar produtos por nome
    List<Produto> findByNomeContaining(String nome);
}
