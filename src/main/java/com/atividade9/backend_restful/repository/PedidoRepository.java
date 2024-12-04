package com.atividade9.backend_restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividade9.backend_restful.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Busca personalizada por ID do cliente
    List<Pedido> findByIdCliente(Long idCliente);

    // Busca personalizada para verificar pedidos contendo um produto específico
    List<Pedido> findByIdsProdutosContaining(Long idProduto);
}
