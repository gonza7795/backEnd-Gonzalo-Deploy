/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Repository;

import com.portfolio.gea.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gonza
 */

    
    public interface RProyectos extends JpaRepository <Proyectos, Integer> {
    
     
       public Optional<Proyectos> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);
    
    
}
