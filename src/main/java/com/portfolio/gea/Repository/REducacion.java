/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.gea.Repository;

import com.portfolio.gea.Entity.Educacion;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Gonza
 */

@Repository
public interface REducacion extends JpaRepository <Educacion, Integer> {
    
       public Optional<Educacion> findByNombreEduc(String nombreEduc);
    public boolean existsByNombreEduc(String nombreEduc);
    
    
    
   
    
}
