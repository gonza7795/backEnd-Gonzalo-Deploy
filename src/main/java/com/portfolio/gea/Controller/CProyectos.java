/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Controller;



import com.portfolio.gea.Dto.dtoProyectos;

import com.portfolio.gea.Entity.Proyectos;
import com.portfolio.gea.Security.Controller.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.portfolio.gea.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Gonza
 */


@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://portfolio-gea.web.app")
public class CProyectos {
    
      @Autowired
      
      SProyectos sProyectos;
      
      
          @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
         @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    
    
       @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    
      @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtopro){      
        if(StringUtils.isBlank(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyectos.existsByNombrePro(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtopro.getNombrePro(), dtopro.getDescripcionPro(), dtopro.getImgPro());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }
    
    
      @PutMapping("/update/{id}")
      
      
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtopro){
            
            
            
    
             //Compara nombre de experiencias
        if(sProyectos.existsByNombrePro(dtopro.getNombrePro()) && sProyectos.getByNombrePro(dtopro.getNombrePro()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
             //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
            
            
              Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombrePro(dtopro.getNombrePro());
        proyectos.setDescripcionPro((dtopro.getDescripcionPro()));
        proyectos.setImgPro((dtopro.getImgPro()));
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("proyecto actualizado"), HttpStatus.OK);
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
      
    
}
