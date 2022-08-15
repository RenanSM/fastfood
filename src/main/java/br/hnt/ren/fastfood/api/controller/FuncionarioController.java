/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.hnt.ren.fastfood.api.controller;


import br.hnt.ren.fastfood.domain.model.Funcionario;
import br.hnt.ren.fastfood.domain.repository.FuncionarioRepository;
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
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/funcionario")
    public List<Funcionario> showAllFuncionario() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public ResponseEntity<Funcionario> showFuncionario(@PathVariable Long funcionarioId) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/funcionario")
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    
}
