package com.example.demo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "instrumento")
public class Instrumento {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "instrumento")
    private Set<Artista> artista = new HashSet<>();

    public Instrumento(String p_nombre) {
        this.nombre = p_nombre;
    }

    public Instrumento(){}

    public Long getId() {
        return id;
    }

    public void setId(Long p_id) {
        this.id = p_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public Set<Artista> getArtistas() {
        return artista;
    }

    public void setArtistas(Set<Artista> p_artista) {
        this.artista = p_artista;
    }
}
