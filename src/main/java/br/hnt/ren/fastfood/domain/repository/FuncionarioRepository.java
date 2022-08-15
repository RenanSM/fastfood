/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.hnt.ren.fastfood.domain.repository;

import br.hnt.ren.fastfood.domain.model.Funcionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author renan
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByNomeContaining(String nome);
    Funcionario findById(long id);
    
}
