package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "disco")
public class Disco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ElementCollection(targetClass = Genero.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "disco_genero", joinColumns = @JoinColumn(name = "disco_id"))
    @Column(name = "genero_id")
    private Set<Genero> genero;
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;
    @ManyToMany
    @JoinTable(
            name = "disco_cancion",
            joinColumns = @JoinColumn(name = "disco_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    private Set<Cancion> cancion;
    @ManyToOne
    @JoinColumn(name="artista_id")
    @JsonManagedReference
    private Artista artista;

    public Disco(String p_nombre, Set<Genero> p_genero, Date p_fecha_lanzamiento){
        this.nombre=p_nombre;
        this.genero=p_genero;
        this.fechaLanzamiento=p_fecha_lanzamiento;
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
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(Date p_fecha_lanzamiento){
        this.fechaLanzamiento=p_fecha_lanzamiento;
    }
    public Set<Cancion> getCancion(){
        return cancion;
    }

    public void setCancion(Set<Cancion> p_cancion){
        this.cancion=p_cancion;
    }

    public Artista getArtista(){
        return artista;
    }
    public void setArtista(Artista p_artista){
        this.artista=p_artista;
    }
}
