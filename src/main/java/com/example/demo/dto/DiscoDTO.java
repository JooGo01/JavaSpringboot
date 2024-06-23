package com.example.demo.dto;

import com.example.demo.model.Artista;
import com.example.demo.model.Cancion;
import com.example.demo.model.Genero;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DiscoDTO {
    private String nombre;
    private Date fechaLanzamiento;
    private Long artista;
    private Set<Genero> genero = new HashSet<>();

    private Set<Long> cancion = new HashSet<>();

    public DiscoDTO() {
    }
    public DiscoDTO(String nombre, Date fecha_lanzamiento, Set<Genero> genero) {
        this.nombre = nombre;
        this.fechaLanzamiento = fecha_lanzamiento;
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
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Long getArtista() {
        return artista;
    }

    public void setArtista(Long artista) {
        this.artista = artista;
    }

    public Set<Genero> getGenero() {
        return genero;
    }

    public void setGenero(Set<Genero> genero) {
        this.genero = genero;
    }

    public Set<Long> getCancion() {
        return cancion;
    }

    public void setCancion(Set<Long> cancion) {
        this.cancion = cancion;
    }
}
