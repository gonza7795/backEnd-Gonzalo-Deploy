/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gea.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Gonza
 */
public class dtoHys {
    
     @NotBlank
    private String nombreHys;
    @NotBlank
    private String descripcionHys;
      @NotBlank
    private String imgHys;
     @NotBlank
   private int porcentaje;
        
        
               //Constructores

    public dtoHys() {
    }

    public dtoHys(String nombreHys, String descripcionHys, String imgHys     , int porcentaje  ) {
        this.nombreHys = nombreHys;
        this.descripcionHys = descripcionHys;
        this.imgHys = imgHys;
   this.porcentaje = porcentaje;
    }
        
        //getter and setter

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
