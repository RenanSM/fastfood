/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.hnt.ren.fastfood.domain.repository;

import br.hnt.ren.fastfood.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author renan
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findById(long id);
    

}
