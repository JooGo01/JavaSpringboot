package com.example.demo.controller;

import com.example.demo.dto.ArtistaDTO;
import com.example.demo.dto.CancionDTO;
import com.example.demo.dto.DiscoDTO;
import com.example.demo.model.*;
import com.example.demo.service.ArtistaService;
import com.example.demo.service.CancionService;
import com.example.demo.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/disco")
public class DiscoController {
    @Autowired
    private DiscoService discoService;
    @Autowired
    private CancionService cancionService;
    @Autowired
    private ArtistaService artistaService;
    @PostMapping(value="/",  consumes = {"application/json", "application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
    public Optional<Disco> create(@RequestBody DiscoDTO discoDTO){
        Set<Genero> genero = new HashSet<>();
        for (Genero gen : discoDTO.getGenero()) {
            if (Genero.existe(gen.toString())) {
                genero.add(gen);
            }
        }

        Set<Cancion> canciones = new HashSet<>();
        for (Long id_cancion : discoDTO.getCancion()){
            Cancion can = new Cancion();
            Optional<Cancion> existeCancion = cancionService.findById(id_cancion);
            if(existeCancion.isPresent()){
                canciones.add(existeCancion.get());
            }else{
                throw new RuntimeException("Cancion no existe");
            }
        }

        Artista artista_parametro = new Artista();
        Optional<Artista> existeArtista = artistaService.findByID(discoDTO.getArtista());
        if(existeArtista.isPresent()){
            //existe
            artista_parametro=existeArtista.get();
        }else{
            /*Set<Genero> generoArtista = new HashSet<>();
            Set<Instrumento> instrumentoArtista = new HashSet<>();
            ArtistaDTO artistaDTO = new ArtistaDTO(artista_parametro.getNombre(),artista_parametro.getPais(),artista_parametro.getFechaNacimiento(),artista_parametro.getFechaFallecimiento(),artista_parametro.getBiografia(),instrumentoArtista,generoArtista);
            artista_parametro = new Artista(artistaDTO.getNombre(), artistaDTO.getPais(), artistaDTO.getFechaNacimiento(), artistaDTO.getFechaFallecimiento(), artistaDTO.getBiografia(), genero);
            artistaService.createArtista(artista_parametro);*/
            throw new RuntimeException("Artista no existe");
        }

        Disco disco = new Disco(discoDTO.getNombre(),genero,discoDTO.getFechaLanzamiento());
        disco.setArtista(artista_parametro);
        disco.setCancion(canciones);
        Optional<Disco> discoCreado = discoService.createDisco(disco);
        return discoCreado;
    }
    @GetMapping("/")
    public Set<Disco> findAll(){
        return discoService.findAll();
    }

    @GetMapping("/busqueda/nombre/{nombre}")
    public Set<Disco> findByNombre(@PathVariable String nombre){
        return discoService.findByNombreContainingIgnoreCase(nombre);
    }

    @GetMapping("/busqueda/genero/{genero}")
    public Optional<Artista> findByGenero(@PathVariable String genero){
        Genero gen;
        if (Genero.existe(genero)) {
            gen = Genero.valueOf(genero);
        } else {
            gen = null;
        }
        return artistaService.findByGenero(gen);
    }
}
