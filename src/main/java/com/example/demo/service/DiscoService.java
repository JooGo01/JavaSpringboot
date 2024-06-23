package com.example.demo.service;

import com.example.demo.model.Artista;
import com.example.demo.model.Disco;
import com.example.demo.model.Genero;
import com.example.demo.repository.DiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiscoService {
    @Autowired
    private DiscoRepository discoRepository;

    public Optional<Disco> createDisco(Disco disco){
        discoRepository.save(disco);
        return null;
    }

    public Set<Disco> findAll(){
        List<Disco> disco_lista = new ArrayList<>();
        disco_lista = discoRepository.findAll();
        Set<Disco> disco = new HashSet<>(disco_lista);
        return disco;
    }

    public Set<Disco> findByNombreContainingIgnoreCase(String nombre){
        Set<Disco> disco = new HashSet<>();
        disco = discoRepository.findByNombreContainingIgnoreCase(nombre);
        return disco;
    }

    public Set<Disco> findByGenero(Genero genero){
        return discoRepository.findByGenero(genero);
    }

    public Set<Disco> findByFechaLanzamiento(Date fecha){
        return discoRepository.findByFechaLanzamiento(fecha);
    }
}
