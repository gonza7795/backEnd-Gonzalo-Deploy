/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gonza
 */

@Entity
public class Hys {
    
    
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       
        private int id;
    private String nombreHys;
    private String descripcionHys;
    private String imgHys;
  private int porcentaje;

    
    //constructor
    public Hys() {
    }

    public Hys(String nombreHys, String descripcionHys, String imgHys,   int porcentaje   ) {
      
        this.nombreHys = nombreHys;
        this.descripcionHys = descripcionHys;
        this.imgHys = imgHys;
       this.porcentaje = porcentaje;
    }

   
    
    
       // getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHys() {
        return nombreHys;
    }

    public void setNombreHys(String nombreHys) {
        this.nombreHys = nombreHys;
    }

    public String getDescripcionHys() {
        return descripcionHys;
    }

    public void setDescripcionHys(String descripcionHys) {
        this.descripcionHys = descripcionHys;
    }

    public String getImgHys() {
        return imgHys;
    }

    public void setImgHys(String imgHys) {
        this.imgHys = imgHys;
    }

public int getPorcentaje() {
     return porcentaje;
 }

    public void setPorcentaje(int porcentaje) {
     this.porcentaje = porcentaje;
 }
    
    
    
    
    

    
    
    
}
