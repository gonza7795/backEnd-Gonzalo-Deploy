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
public class Educacion {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEduc;
    private String descripcionEduc;
    private String imgEduc;

    public Educacion() {
    }

    public Educacion(int id, String nombreEduc, String descripcionEduc, String imgEduc) {
        this.id = id;
        this.nombreEduc = nombreEduc;
        this.descripcionEduc = descripcionEduc;
        this.imgEduc = imgEduc;
    }

    public Educacion(String nombreEduc, String descripcionEduc, String imgEduc) {
        
            this.nombreEduc = nombreEduc;
        this.descripcionEduc = descripcionEduc;
        this.imgEduc = imgEduc;
 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
