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
public class dtoEducacion {
    
    
    @NotBlank
    private String nombreEduc;
    @NotBlank
    private String descripcionEduc;
      @NotBlank
    private String imgEduc;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEduc, String descripcionEduc, String imgEduc) {
        this.nombreEduc = nombreEduc;
        this.descripcionEduc = descripcionEduc;
        this.imgEduc = imgEduc;
    }

    public String getNombreEduc() {
        return nombreEduc;
    }

    public void setNombreEduc(String nombreEduc) {
        this.nombreEduc = nombreEduc;
    }

    public String getDescripcionEduc() {
        return descripcionEduc;
    }

    public void setDescripcionEduc(String descripcionEduc) {
        this.descripcionEduc = descripcionEduc;
    }

    public String getImgEduc() {
        return imgEduc;
    }

    public void setImgEduc(String imgEduc) {
        this.imgEduc = imgEduc;
    }
      
      
      
      
    
}
