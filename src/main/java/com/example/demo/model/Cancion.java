package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre, letra;

    @ElementCollection(targetClass = Genero.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "cancion_genero", joinColumns = @JoinColumn(name = "cancion_id"))
    @Column(name = "genero_id")
    private Set<Genero> genero = new HashSet<>();

    @ManyToMany(mappedBy = "cancion")
    private Set<Disco> disco = new HashSet<>();

    public Cancion(String p_nombre, String p_letra, Set<Genero> p_genero){
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

    public Set<Genero> getGenero(){
        return genero;
    }

    public void setGenero(Set<Genero> genero){
        this.genero=genero;
    }
}
