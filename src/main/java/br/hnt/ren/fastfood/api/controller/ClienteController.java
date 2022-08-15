/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.hnt.ren.fastfood.api.controller;

import br.hnt.ren.fastfood.domain.model.Cliente;
import br.hnt.ren.fastfood.domain.repository.ClienteRepository;
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
public class ClienteController {
        
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("/cliente")
    public List<Cliente> showAllCliente() {
        return clienteRepository.findAll();
    }
    
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<Cliente> showCliente(@PathVariable Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
