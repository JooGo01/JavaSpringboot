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
    public Optional<Artista> findByGenero(Genero genero){
        return artistaRepository.findByGenero(genero);
    }

    public Optional<Artista> findByPais(String pais){
        return artistaRepository.findByPaisContainingIgnoreCase(pais);
    }
    public Set<Artista> findArtistasByInstrumento(Set<String> instrumento){
        Set<Artista> artistas = new HashSet<>();
        artistas = artistaRepository.findArtistasByInstrumento(instrumento);
        return artistas;
    }
    public Set<Artista> findByEdad(Integer edad){
        Set<Artista> artistas = new HashSet<>();
        artistas = artistaRepository.findByEdad(edad);
        return artistas;
    }
    public Set<Artista> findByCancion(Long cancion){
        return artistaRepository.findByCancion(cancion);
    }

    public Optional<Artista> findByFechaFallecimientoIsNull(){
        return artistaRepository.findByFechaFallecimientoIsNull();
    }
    public Optional<Artista> findByFechaFallecimientoIsNotNull(){
        return artistaRepository.findByFechaFallecimientoIsNotNull();
    }
    public Optional<Artista> findByNombre(String nombre){
        return artistaRepository.findByNombre(nombre);
    }
}
