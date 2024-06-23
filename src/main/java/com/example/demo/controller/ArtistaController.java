package com.example.demo.controller;

import com.example.demo.dto.ArtistaDTO;
import com.example.demo.model.Artista;
import com.example.demo.model.Genero;
import com.example.demo.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    public Optional<Artista> create(@RequestBody ArtistaDTO artistaDTO){
        Set<Genero> genero = new HashSet<>();
        for (Genero gen : artistaDTO.getGenero()) {
            if (Genero.existe(gen.toString())) {
                genero.add(gen);
            } else {
                genero.add(Genero.Clásica);
            }
        }

        Artista artista = new Artista(artistaDTO.getPais(), artistaDTO.getFechaNacimiento(), artistaDTO.getFechaFallecimiento(), artistaDTO.getBiografia(), genero);
        //return artistaService.save(artista);
        return null;
    }
}
