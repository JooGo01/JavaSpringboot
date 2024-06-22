package com.example.demo.model;

import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.*;

@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection(targetClass = Genero.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "artista_genero", joinColumns = @JoinColumn(name = "artista_id"))
    @Column(name = "genero")
    private Set<Genero> genero;
    private String pais;
    private Date fecha_nacimiento;
    private Date fecha_fallecimiento;
    @ManyToMany
    @JoinTable(
            name = "artista_instrumento",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "instrumento_id")
    )
    private Set<Instrumento> instrumento;
    private String biografia;
    @OneToMany(mappedBy = "artista")
    private Set<Disco> disco;

    public Artista(Set<Genero> p_genero, String p_pais, Date p_fecha_nacimiento, Date p_fecha_fallecimiento, Set<Instrumento> p_instrumento, String p_biografia, Set<Disco> p_disco){
        this.genero=p_genero;
        this.pais=p_pais;
        this.fecha_nacimiento=p_fecha_nacimiento;
        this.fecha_fallecimiento=p_fecha_fallecimiento;
        this.instrumento=p_instrumento;
        this.biografia=p_biografia;
        this.disco=p_disco;
    }

    public Artista(){
    }

    public Long getId(){
        return id;
    }
    public void setId(Long p_id){
        this.id=p_id;
    }

    public Set<Genero> getGenero(){
        return genero;
    }
    public void setGenero(Set<Genero> p_genero){
        this.genero=p_genero;
    }

    public String getPais(){
        return pais;
    }
    public void setPais(String p_pais){
        this.pais=p_pais;
    }
    public Date getFechaNacimiento(){
        return fecha_nacimiento;
    }
    public void setPais(Date p_fecha_nac){
        this.fecha_nacimiento=p_fecha_nac;
    }

    public Date getFechaFallecimiento(){
        return fecha_fallecimiento;
    }
    public void setFechaFallecimiento(Date p_fecha_fal){
        this.fecha_fallecimiento=p_fecha_fal;
    }

    public Set<Instrumento> getInstrumento(){
        return instrumento;
    }
    public void setInstrumento(Set<Instrumento> p_instrumento){
        this.instrumento=p_instrumento;
    }

    public String getBiografia(){
        return biografia;
    }
    public void setBiografia(String p_biografia){
        this.biografia=p_biografia;
    }

    public Set<Disco> getDisco(){
        return disco;
    }
    public void setDisco(Set<Disco> p_disco){
        this.disco=p_disco;
    }
}
