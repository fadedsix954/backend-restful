package com.atividade9.backend_restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade9.backend_restful.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Busca personalizada para encontrar clientes por nome
    List<Cliente> findByNomeContaining(String nome);
}

