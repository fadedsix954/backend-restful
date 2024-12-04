package com.atividade9.backend_restful.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atividade9.backend_restful.model.Pedido;
import com.atividade9.backend_restful.repository.ClienteRepository;
import com.atividade9.backend_restful.repository.PedidoRepository;
import com.atividade9.backend_restful.repository.ProdutoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido salvarPedido(Pedido pedido) {
        if (!clienteRepository.existsById(pedido.getIdCliente())) {
            throw new IllegalArgumentException("Cliente inválido!");
        }

        for (Long idProduto : pedido.getIdsProdutos()) {
            if (!produtoRepository.existsById(idProduto)) {
                throw new IllegalArgumentException("Produto inválido: " + idProduto);
            }
        }

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado!"));
    }

    public List<Pedido> buscarPorIdCliente(Long idCliente) {
        return pedidoRepository.findByIdCliente(idCliente);
    }
}
