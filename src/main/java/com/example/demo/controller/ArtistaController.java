package com.example.demo.controller;

import com.example.demo.dto.ArtistaDTO;
import com.example.demo.dto.InstrumentoDTO;
import com.example.demo.model.Artista;
import com.example.demo.model.Cancion;
import com.example.demo.model.Genero;
import com.example.demo.model.Instrumento;
import com.example.demo.service.ArtistaService;
import com.example.demo.service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;
    @Autowired
    private InstrumentoService instrumentoService;

    @PostMapping(value="/",  consumes = {"application/json", "application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
    public Optional<Artista> create(@RequestBody ArtistaDTO artistaDTO){
        Set<Genero> genero = new HashSet<>();
        for (Genero gen : artistaDTO.getGenero()) {
            if (Genero.existe(gen.toString())) {
                genero.add(gen);
            } else {
                genero.add(Genero.Clásica);
            }
        }
        Set<Instrumento> instrumento = new HashSet<>();
        for (Instrumento inst : artistaDTO.getInstrumento()) {
            Optional<Instrumento> existingInstrumento = instrumentoService.findByNombre(inst.getNombre());
            if(existingInstrumento.isPresent()){
                instrumento.add(existingInstrumento.get());
            }else{
                InstrumentoDTO instrumentoDTO = new InstrumentoDTO(inst.getNombre());
                Instrumento instrumentoNuevo = new Instrumento(instrumentoDTO.getNombre());
                instrumento.add(instrumentoNuevo);
                instrumentoService.createInstrumento(instrumentoNuevo);
            }
        }

        Artista artista = new Artista(artistaDTO.getPais(), artistaDTO.getFechaNacimiento(), artistaDTO.getFechaFallecimiento(), artistaDTO.getBiografia(), genero);
        artista.setInstrumento(instrumento);
        Optional<Artista> artistaCreado= artistaService.createArtista(artista);
        return artistaCreado;
    }

    @GetMapping("/")
    public List<Artista> findAll(){
        return artistaService.findAll();
    }
}
