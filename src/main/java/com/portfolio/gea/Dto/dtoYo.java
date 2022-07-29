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
public class dtoYo {
    
    
      @NotBlank
    private String nombreYo;
    @NotBlank
    private String descripcionYo;
      @NotBlank
    private String imgYo;
     @NotBlank
   private String tituloYo;
     
     
     
           //Constructores
     
      
     
     
        
  

    public dtoYo() {
    }
    
    
      
    
       

    public dtoYo(String nombreYo, String descripcionYo, String imgYo, String tituloYo) {
        this.nombreYo = nombreYo;
        this.descripcionYo = descripcionYo;
        this.imgYo = imgYo;
        this.tituloYo = tituloYo;
    }
     
    
     //getter and setter

    public String getNombreYo() {
        return nombreYo;
    }

    public void setNombreYo(String nombreYo) {
        this.nombreYo = nombreYo;
    }

    public String getDescripcionYo() {
        return descripcionYo;
    }

    public void setDescripcionYo(String descripcionYo) {
        this.descripcionYo = descripcionYo;
    }

    public String getImgYo() {
        return imgYo;
    }

    public void setImgYo(String imgYo) {
        this.imgYo = imgYo;
    }

    public String getTituloYo() {
        return tituloYo;
    }

    public void setTituloYo(String tituloYo) {
        this.tituloYo = tituloYo;
    }
    
    
    
     
     
    
}
