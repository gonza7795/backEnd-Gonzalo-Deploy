/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Controller;



import com.portfolio.gea.Dto.dtoYo;

import com.portfolio.gea.Entity.Yo;

import com.portfolio.gea.Security.Controller.Mensaje;
import com.portfolio.gea.Service.SYo;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Gonza
 */

@RestController
@RequestMapping("/yo")
@CrossOrigin(origins = "https://portfolio-gea.web.app")


public class CYo {
    
       @Autowired
       
       
       SYo sYo;
       
       
       
              @GetMapping("/lista")
    public ResponseEntity<List<Yo>> list(){
        List<Yo> list = sYo.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    
    
       @GetMapping("/detail/{id}")
    public ResponseEntity<Yo> getById(@PathVariable("id") int id){
        if(!sYo.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Yo yo = sYo.getOne(id).get();
        return new ResponseEntity(yo, HttpStatus.OK);
    }
    
    
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sYo.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sYo.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    
    
    
    
       @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoYo dtoyo){      
        if(StringUtils.isBlank(dtoyo.getNombreYo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sYo.existsByNombreYo(dtoyo.getNombreYo()))
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        
            Yo yo = new Yo(dtoyo.getNombreYo(), dtoyo.getDescripcionYo(), dtoyo.getImgYo(), dtoyo.getTituloYo() );
            
                      sYo.save(yo);
        
        
   
        return new ResponseEntity(new Mensaje("Hys agregada"), HttpStatus.OK);
    }
    
    
    
    
    
     @PutMapping("/update/{id}")
      
      
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoYo dtoyo){
            
            
            
    
             //Compara nombre de experiencias
        if(sYo.existsByNombreYo(dtoyo.getNombreYo()) && sYo.getByNombreYo(dtoyo.getNombreYo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese item ya existe"), HttpStatus.BAD_REQUEST);
             //No puede estar vacio
        if(StringUtils.isBlank(dtoyo.getNombreYo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
            
            
              Yo yo = sYo.getOne(id).get();
        yo.setNombreYo(dtoyo.getNombreYo());
        yo.setDescripcionYo((dtoyo.getDescripcionYo()));
        yo.setImgYo((dtoyo.getImgYo()));
        yo.setTituloYo((dtoyo.getTituloYo()));
        
        sYo.save(yo);
        return new ResponseEntity(new Mensaje("Item actualizado"), HttpStatus.OK);
        }
    
    
    
    
    
    
       
       
       
       
       
    
    
    
    
    
}
