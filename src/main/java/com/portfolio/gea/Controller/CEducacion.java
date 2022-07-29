/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Controller;

import com.portfolio.gea.Dto.dtoEducacion;


import com.portfolio.gea.Entity.Educacion;


import com.portfolio.gea.Security.Controller.Mensaje;

import com.portfolio.gea.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://portfolio-gea.web.app")
public class CEducacion {
    
     @Autowired
    SEducacion sEducacion;
     
     
      @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
       @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    
    
    
       @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeduc){      
        if(StringUtils.isBlank(dtoeduc.getNombreEduc()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByNombreEduc(dtoeduc.getNombreEduc()))
            return new ResponseEntity(new Mensaje("Esa Educacion existe"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoeduc.getNombreEduc(), dtoeduc.getDescripcionEduc(), dtoeduc.getImgEduc());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeduc){
        //Validamos si existe el ID
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sEducacion.existsByNombreEduc(dtoeduc.getNombreEduc()) && sEducacion.getByNombreEduc(dtoeduc.getNombreEduc()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoeduc.getNombreEduc()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreEduc(dtoeduc.getNombreEduc());
        educacion.setDescripcionEduc((dtoeduc.getDescripcionEduc()));
        educacion.setImgEduc((dtoeduc.getImgEduc()));
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
    
    
    
    
    
}



