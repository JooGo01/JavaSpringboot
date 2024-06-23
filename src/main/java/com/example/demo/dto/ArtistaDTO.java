package com.example.demo.dto;

import com.example.demo.model.Disco;
import com.example.demo.model.Genero;
import com.example.demo.model.Instrumento;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ArtistaDTO {
    private String pais;
    private Date fechaNacimiento;
    private Date fechaFallecimiento;
    private String biografia;
    private Set<Instrumento> instrumento = new HashSet<>();
    private Set<Genero> genero= new HashSet<>();
    private Set<Disco> disco= new HashSet<>();

    // Constructor sin argumentos
    public ArtistaDTO() {
    }

    // Constructor con argumentos
    public ArtistaDTO(String pais, Date fechaNacimiento, Date fechaFallecimiento, String biografia, Set<Instrumento> instrumento, Set<Genero> genero) {
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
        this.biografia = biografia;
        this.instrumento = instrumento;
        this.genero = genero;
    }

    // Getters y Setters
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Set<Instrumento> getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Set<Instrumento> instrumento) {
        this.instrumento = instrumento;
    }

    public Set<Genero> getGenero() {
        return genero;
    }

    public void setGenero(Set<Genero> genero) {
        this.genero = genero;
    }

    public Set<Disco> getDisco() {
        return disco;
    }

    public void setDisco(Set<Disco> disco) {
        this.disco = disco;
    }
}
