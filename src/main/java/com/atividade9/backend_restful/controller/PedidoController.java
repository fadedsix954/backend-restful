package com.atividade9.backend_restful.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atividade9.backend_restful.model.Pedido;
import com.atividade9.backend_restful.service.PedidoService;

@RestController
@RequestMapping("/pedidos")  // Define o caminho base para os endpoints de Pedido
public class PedidoController {

    private final PedidoService pedidoService;

    // Injeção de dependência do PedidoService
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Endpoint para salvar um novo pedido
    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        return pedidoService.salvarPedido(pedido);
    }

    // Endpoint para listar todos os pedidos
    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    // Endpoint para buscar um pedido pelo ID
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    // Endpoint para buscar pedidos por ID do cliente
    @GetMapping("/buscar-por-cliente")
    public List<Pedido> buscarPorIdCliente(@RequestParam Long idCliente) {
        return pedidoService.buscarPorIdCliente(idCliente);
    }
}
