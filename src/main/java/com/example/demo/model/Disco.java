package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "disco")
public class Disco {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    @ElementCollection(targetClass = Genero.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "disco_genero", joinColumns = @JoinColumn(name = "disco_id"))
    @Column(name = "genero")
    private Set<Genero> genero;
    private Date fecha_lanzamiento;
    @ManyToMany
    @JoinTable(
            name = "disco_cancion",
            joinColumns = @JoinColumn(name = "disco_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    private Set<Cancion> cancion;
    @ManyToOne
    @JoinColumn(name="artista_id")
    private Artista artista;

    public Disco(String p_nombre, Set<Genero> p_genero, Date p_fecha_lanzamiento, Set<Cancion> p_cancion){
        this.nombre=p_nombre;
        this.genero=p_genero;
        this.fecha_lanzamiento=p_fecha_lanzamiento;
        this.cancion=p_cancion;
    }

    public Disco(){}

    public Long getId(){
        return id;
    }

    public void setId(Long p_id){
        this.id=p_id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String p_nombre){
        this.nombre=p_nombre;
    }
    public Set<Genero> getGenero(){
        return genero;
    }
    public void setGenero(Set<Genero> p_genero){
        this.genero=p_genero;
    }
    public Date getFechaLanzamiento(){
        return fecha_lanzamiento;
    }
    public void setFechaLanzamiento(Date p_fecha_lanzamiento){
        this.fecha_lanzamiento=p_fecha_lanzamiento;
    }
    public Set<Cancion> getCancion(){
        return cancion;
    }

    public void setCancion(Set<Cancion> p_cancion){
        this.cancion=p_cancion;
    }
}
