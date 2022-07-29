/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.gea.Repository;

import com.portfolio.gea.Entity.Hys;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gonza
 */
public interface RHys extends JpaRepository <Hys, Integer> {
    
      public Optional<Hys> findByNombreHys(String nombreHys);
      
      public boolean existsByNombreHys(String nombreHys);
    
    
    
}
