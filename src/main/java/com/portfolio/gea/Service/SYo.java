/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Service;

import com.portfolio.gea.Entity.Yo;
import com.portfolio.gea.Repository.RYo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gonza
 */



@Service
@Transactional
public class SYo {
    
    
        @Autowired
        
        RYo rYo;
        
        
          public List<Yo> list(){
         return rYo.findAll();
     }
     
     public Optional<Yo> getOne(int id){
         return rYo.findById(id);
     }
     
     public Optional<Yo> getByNombreYo(String nombreYo){
         return rYo.findByNombreYo(nombreYo);
     }
     
     public void save(Yo yo){
         rYo.save(yo);
     }
     
     public void delete(int id){
         rYo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return rYo.existsById(id);
     }
     
     public boolean existsByNombreYo(String nombreYo){
         return rYo.existsByNombreYo(nombreYo);
     }
        
        
    
}
