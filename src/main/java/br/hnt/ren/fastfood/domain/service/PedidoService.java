/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.hnt.ren.fastfood.domain.service;

import br.hnt.ren.fastfood.domain.model.Pedido;
import br.hnt.ren.fastfood.domain.model.StatusPedido;
import br.hnt.ren.fastfood.domain.repository.PedidoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author renan
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public void salvar(Pedido pedido) {
        // Atualiza campos abertoEm e status
        pedido.setAbertoEm(LocalDateTime.now());
        pedido.setStatus(StatusPedido.ABERTO);
        
        pedidoRepository.save(pedido);
    }
}
