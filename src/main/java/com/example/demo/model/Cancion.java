package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre, letra;

    private String genero;

    public Cancion(String p_nombre, String p_letra, String p_genero){
        this.nombre = p_nombre;
        this.letra = p_letra;
        this.genero=p_genero;
    }
    public Cancion(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }
}
