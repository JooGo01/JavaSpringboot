package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "discos")
public class Disco {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    @ElementCollection(targetClass = Genero.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "disco_genero")
    @Column(name = "genero")
    private List<Genero> genero;
    private Date fecha_lanzamiento;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="cancion_id")
    private List<Cancion> cancion;

    public Disco(String p_nombre, ArrayList<Genero> p_genero, Date p_fecha_lanzamiento, ArrayList<Cancion> p_cancion){
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
    public List<Genero> getGenero(){
        return genero;
    }
    public void setGenero(ArrayList<Genero> p_genero){
        this.genero=p_genero;
    }
    public Date getFechaLanzamiento(){
        return fecha_lanzamiento;
    }
    public void setFechaLanzamiento(Date p_fecha_lanzamiento){
        this.fecha_lanzamiento=p_fecha_lanzamiento;
    }
    public List<Cancion> getCancion(){
        return cancion;
    }

    public void setCancion(ArrayList<Cancion> p_cancion){
        this.cancion=p_cancion;
    }
}
