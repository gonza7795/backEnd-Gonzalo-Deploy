/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Controller;

import com.portfolio.gea.Dto.dtoHys;

import com.portfolio.gea.Entity.Hys;

import com.portfolio.gea.Security.Controller.Mensaje;
import com.portfolio.gea.Service.SHys;
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
@RequestMapping("/hys")
@CrossOrigin(origins = "https://portfolio-gea.web.app")

public class CHys {
    
    
         @Autowired
         
         
          SHys sHys;
    
 
          @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list(){
        List<Hys> list = sHys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    
         @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id){
        if(!sHys.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Hys hys = sHys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sHys.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    
      @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys){      
        if(StringUtils.isBlank(dtohys.getNombreHys()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sHys.existsByNombreHys(dtohys.getNombreHys()))
            return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
        
            Hys hys = new Hys(dtohys.getNombreHys(), dtohys.getDescripcionHys(), dtohys.getImgHys(), dtohys.getPorcentaje() );
            
                      sHys.save(hys);
        
        
   
        return new ResponseEntity(new Mensaje("Hys agregada"), HttpStatus.OK);
    }
    
    
      @PutMapping("/update/{id}")
      
      
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys){
            
            
            
    
             //Compara nombre de experiencias
        if(sHys.existsByNombreHys(dtohys.getNombreHys()) && sHys.getByNombreHys(dtohys.getNombreHys()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese hys ya existe"), HttpStatus.BAD_REQUEST);
             //No puede estar vacio
        if(StringUtils.isBlank(dtohys.getNombreHys()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
            
            
            
              Hys hys = sHys.getOne(id).get();
        hys.setNombreHys(dtohys.getNombreHys());
        hys.setDescripcionHys((dtohys.getDescripcionHys()));
        hys.setImgHys((dtohys.getImgHys()));
        hys.setPorcentaje((dtohys.getPorcentaje()));
        
        sHys.save(hys);
        return new ResponseEntity(new Mensaje("hys actualizado"), HttpStatus.OK);
        }
    
    
    
   
}
