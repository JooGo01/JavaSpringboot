package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "instrumento")
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "instrumento")
    @JsonBackReference
    @JsonIgnore
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

    public Set<Artista> getArtista() {
        return artista;
    }

    public void setArtista(Set<Artista> p_artista) {
        this.artista = p_artista;
    }
}
