package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Artista {
    @Id
    @GeneratedValue
    private Long id;
    private List<Genero> genero;
    private String pais;
    private Date fecha_nacimiento;
    private Date fecha_fallecimiento;
    private List<String> instrumento;
    private String biografia;
    private List<Disco> disco;

    public Artista(ArrayList<Genero> p_genero, String p_pais, Date p_fecha_nacimiento, Date p_fecha_fallecimiento, ArrayList<String> p_instrumento, String p_biografia, ArrayList<Disco> p_disco){
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

    public List<Genero> getGenero(){
        return genero;
    }
    public void setGenero(ArrayList<Genero> p_genero){
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

    public List<String> getInstrumento(){
        return instrumento;
    }
    public void setInstrumento(ArrayList<String> p_instrumento){
        this.instrumento=p_instrumento;
    }

    public String getBiografia(){
        return biografia;
    }
    public void setBiografia(String p_biografia){
        this.biografia=p_biografia;
    }

    public List<Disco> getDisco(){
        return disco;
    }
    public void setDisco(ArrayList<Disco> p_disco){
        this.disco=p_disco;
    }
}
