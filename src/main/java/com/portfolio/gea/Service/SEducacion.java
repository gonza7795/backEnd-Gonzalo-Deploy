/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Service;

import com.portfolio.gea.Entity.Educacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.portfolio.gea.Repository.REducacion;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Gonza
 */

@Service
@Transactional
public class SEducacion {
    
     @Autowired
     REducacion rEducacion;
    
    
    public List<Educacion> list(){
         return rEducacion.findAll();
     }
     
     public Optional<Educacion> getOne(int id){
         return rEducacion.findById(id);
     }
     
     public Optional<Educacion> getByNombreEduc(String nombreEduc){
         return rEducacion.findByNombreEduc(nombreEduc);
     }
     
     public void save(Educacion educ){
         rEducacion.save(educ);
     }
     
     public void delete(int id){
         rEducacion.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rEducacion.existsById(id);
     }
     
     public boolean existsByNombreEduc(String nombreE){
         return rEducacion.existsByNombreEduc(nombreE);
     }
    
    
    
}
