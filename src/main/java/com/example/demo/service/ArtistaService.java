package com.example.demo.service;

import com.example.demo.model.Artista;
import com.example.demo.model.Cancion;
import com.example.demo.model.Genero;
import com.example.demo.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public Optional<Artista> createArtista(Artista artista){
        artistaRepository.save(artista);
        return null;
    }

    public List<Artista> findAll(){
        List<Artista> artistas = new ArrayList<>();
        artistas=artistaRepository.findAll();
        for(Artista artista: artistas){
            System.out.println("Id: " + artista.getId());
            System.out.println("Pais: " + artista.getPais());
            System.out.println("Genero: " + artista.getGenero());
            for(Genero genero : artista.getGenero()) {
                System.out.println("Genero: " + artista.toString());
            }
            /*for(Disco disco : can.getDisco()) {
                System.out.println("Disco: " + disco.getNombre());
            }*/
        }
        return artistas;
    }

    public Optional<Artista> findByID(Long id){
        return artistaRepository.findById(id);
    }
    public Optional<Artista> findByGenero(String genero){
        return artistaRepository.findByGenero(genero);
    }

    public Optional<Artista> findByPais(String pais){
        return artistaRepository.findByPais(pais);
    }
    public Optional<Artista> findByInstrumento(Set<String> instrumento){
        return artistaRepository.findArtistasByInstrumento(instrumento);
    }
    public Optional<Artista> findByEdad(Integer edad){
        return artistaRepository.findByEdad(edad);
    }
    public Optional<Artista> findByCancion(Set<Cancion> cancion){
        return artistaRepository.findByCancion(cancion);
    }

    public Optional<Artista> findByFechaFallecimientoIsNull(){
        return artistaRepository.findByFechaFallecimientoIsNull();
    }
    public Optional<Artista> findByFechaFallecimientoIsNotNull(){
        return artistaRepository.findByFechaFallecimientoIsNull();
    }
}
