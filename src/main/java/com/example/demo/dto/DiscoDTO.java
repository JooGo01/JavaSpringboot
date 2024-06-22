package com.example.demo.dto;

import com.example.demo.model.Genero;

import java.util.Date;
import java.util.Set;

public class DiscoDTO {
    private String nombre;
    private Date fecha_lanzamiento;
    private Integer artista_id;
    private Set<Genero> genero;

    public DiscoDTO() {
    }
    public DiscoDTO(String nombre, Date fecha_lanzamiento, Integer artista_id, Set<Genero> genero) {
        this.nombre = nombre;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.artista_id = artista_id;
        this.genero = genero;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaLanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fecha_lanzamiento = fechaLanzamiento;
    }

    public Integer getArtistaId() {
        return artista_id;
    }

    public void setArtistaId(Integer artista_id) {
        this.artista_id = artista_id;
    }

    public Set<Genero> getGenero() {
        return genero;
    }

    public void setGenero(Set<Genero> genero) {
        this.genero = genero;
    }
}
