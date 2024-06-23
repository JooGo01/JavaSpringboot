package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.*;

@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection(targetClass = Genero.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "artista_genero", joinColumns = @JoinColumn(name = "artista_id"))
    @Column(name = "genero_id")
    private Set<Genero> genero;
    private String pais;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "fecha_fallecimiento")
    private Date fechaFallecimiento;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "artista_instrumento",
            joinColumns = {@JoinColumn(name = "artista_id")},
            inverseJoinColumns = {@JoinColumn(name = "instrumento_id")}
    )
    @JsonManagedReference
    private Set<Instrumento> instrumento = new HashSet<>();
    private String biografia;
    @OneToMany(mappedBy = "artista")
    private Set<Disco> disco;

    public Artista(String p_pais, Date p_fecha_nacimiento, Date p_fecha_fallecimiento, String p_biografia, Set<Genero> p_genero){
        this.pais=p_pais;
        this.fechaNacimiento=p_fecha_nacimiento;
        this.fechaFallecimiento=p_fecha_fallecimiento;
        this.biografia=p_biografia;
        this.genero=p_genero;
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
        return fechaNacimiento;
    }
    public void setPais(Date p_fecha_nac){
        this.fechaNacimiento=p_fecha_nac;
    }

    public Date getFechaFallecimiento(){
        return fechaFallecimiento;
    }
    public void setFechaFallecimiento(Date p_fecha_fal){
        this.fechaFallecimiento=p_fecha_fal;
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
