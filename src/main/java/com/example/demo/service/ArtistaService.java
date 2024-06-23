package com.example.demo.service;

import com.example.demo.model.Artista;
import com.example.demo.model.Cancion;
import com.example.demo.model.Genero;
import com.example.demo.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return artistaRepository.findByID(id);
    }
    public Optional<Artista> findByGenero(String genero){
        return artistaRepository.findByGenero(genero);
    }
}
