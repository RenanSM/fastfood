/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.hnt.ren.fastfood.domain.repository;

import br.hnt.ren.fastfood.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author renan
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    Produto findById(long id);
}
