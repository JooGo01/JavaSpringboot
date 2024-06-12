package com.example.demo.model;

public enum Genero {
    Jazz, Blues, Rock, Electrónica, Clásica, Tango;

    public static boolean existe(String value) {
        for (Genero genero : Genero.values()) {
            if (genero.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static Genero fromString(String value) {
        for (Genero genero : Genero.values()) {
            if (genero.name().equalsIgnoreCase(value)) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Enum no encontrado con valor " + value);
    }
}
