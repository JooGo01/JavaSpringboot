package com.example.demo.dto;

public class InstrumentoDTO {
    private String nombre;

    public InstrumentoDTO() {
    }

    public InstrumentoDTO(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
