package com.example.demo.dto;

import com.example.demo.model.Genero;

import java.util.Date;
import java.util.Set;

public class ArtistaDTO {
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;
    private Date fechaFallecimiento;
    private String biografia;
    private Set<Integer> instrumentoId;
    private Set<Genero> genero;

    // Constructor sin argumentos
    public ArtistaDTO() {
    }

    // Constructor con argumentos
    public ArtistaDTO(String nombre, String nacionalidad, Date fechaNacimiento, Date fechaFallecimiento, String biografia, Set<Integer> instrumentoId, Set<Genero> genero) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
        this.biografia = biografia;
        this.instrumentoId = instrumentoId;
        this.genero = genero;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public Set<Integer> getInstrumentoId() {
        return instrumentoId;
    }

    public void setInstrumentoId(Set<Integer> instrumentoId) {
        this.instrumentoId = instrumentoId;
    }

    public Set<Genero> getGenero() {
        return genero;
    }

    public void setGenero(Set<Genero> genero) {
        this.genero = genero;
    }
}
