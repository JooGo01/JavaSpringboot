package com.example.demo.dto;

import com.example.demo.model.Genero;

import java.util.HashSet;
import java.util.Set;

public class CancionDTO {
    private String nombre;
    private String letra;
    private Set<Genero> genero = new HashSet<>();;

    public CancionDTO() {
    }

    public CancionDTO(String p_nombre, String p_letra, Set<Genero> p_genero) {
        this.nombre = p_nombre;
        this.letra = p_letra;
        this.genero = p_genero;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String p_letra) {
        this.letra = p_letra;
    }

    public Set<Genero> getGenero() {
        return genero;
    }

    public void setGenero(Set<Genero> p_genero) {
        this.genero = p_genero;
    }
}
