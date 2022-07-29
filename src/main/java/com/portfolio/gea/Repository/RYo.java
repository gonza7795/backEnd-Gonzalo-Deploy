/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.gea.Repository;

import com.portfolio.gea.Entity.Yo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gonza
 */
public interface RYo  extends JpaRepository <Yo, Integer> {
    
    
     public Optional<Yo> findByNombreYo(String nombreYo);
      
      public boolean existsByNombreYo(String nombreYo);
    
}
