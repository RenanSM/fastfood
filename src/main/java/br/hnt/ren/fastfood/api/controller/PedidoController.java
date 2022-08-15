/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.hnt.ren.fastfood.api.controller;

import br.hnt.ren.fastfood.domain.model.Pedido;
import br.hnt.ren.fastfood.domain.repository.PedidoRepository;
import br.hnt.ren.fastfood.domain.service.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author renan
 */
@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedido")
    public List<Pedido> showAllPedido() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<Pedido> showPedido(@PathVariable Long pedidoId) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/pedido")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido addPedido(@RequestBody Pedido pedido) {

        pedidoService.salvar(pedido);

        return pedido;
    }
}
