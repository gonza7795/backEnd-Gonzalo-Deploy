
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
public class Yo {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     
     
             private int id;
    private String nombreYo;
    private String descripcionYo;
    private String imgYo;
  private String tituloYo;
  
  
  //constructor

    public Yo() {
    }

    public Yo(String nombreYo, String descripcionYo, String imgYo, String tituloYo) {
        this.nombreYo = nombreYo;
        this.descripcionYo = descripcionYo;
        this.imgYo = imgYo;
        this.tituloYo = tituloYo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
