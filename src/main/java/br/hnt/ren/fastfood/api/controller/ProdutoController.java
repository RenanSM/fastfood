/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.hnt.ren.fastfood.api.controller;

import br.hnt.ren.fastfood.domain.model.Produto;
import br.hnt.ren.fastfood.domain.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author renan
 */
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<Produto> showAllProduto() {
        return produtoRepository.findAll();
    }
    
    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<Produto> showProduto(@PathVariable Long produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
