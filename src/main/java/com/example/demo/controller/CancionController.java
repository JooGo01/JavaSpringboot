package com.example.demo.controller;

import com.example.demo.dto.CancionDTO;
import com.example.demo.model.Cancion;
import com.example.demo.model.Genero;
import com.example.demo.model.User;
import com.example.demo.service.CancionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/cancion")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @GetMapping("/busqueda/id/{id}")
    public Optional<Cancion> searchUserById(@PathVariable long id){
        return cancionService.findById(id);
    }

    @GetMapping("/")
    public List<Cancion> findAll(){
        return cancionService.findAll();
    }

    @PostMapping(value="/",  consumes = {"application/json", "application/x-www-form-urlencoded", MediaType.APPLICATION_JSON_VALUE})
    public Optional<Cancion> create(@RequestBody CancionDTO cancionDTO){
        Set<Genero> genero = new HashSet<>();
        for (Genero gen : cancionDTO.getGenero()) {
            if (Genero.existe(gen.toString())) {
                genero.add(gen);
            } else {
                genero.add(Genero.Clásica);
            }
        }
        Cancion cancion = new Cancion(cancionDTO.getNombre(), cancionDTO.getLetra(), genero);
        Optional<Cancion> cancionCreada = cancionService.createCancion(cancion);
        return cancionCreada;
    }

    /*public Optional<Cancion> create(@RequestBody Map<String, Object> requestBody){
        String nombre = requestBody.get("nombre").toString();
        String letra= requestBody.get("letra").toString();
        Object generoObj = requestBody.get("genero");
        Set<Genero> genero = new HashSet<>();
        if (generoObj instanceof String) {
            String strGenero = (String) generoObj;
            if (Genero.existe(strGenero)) {
                genero.add(Genero.fromString(strGenero));
            } else {
                genero.add(Genero.Clásica);
            }
        } else if (generoObj instanceof List) {
            List<String> generosList = (List<String>) generoObj;
            for (String strGenero : generosList) {
                if (Genero.existe(strGenero)) {
                    genero.add(Genero.fromString(strGenero));
                } else {
                    genero.add(Genero.Clásica);
                }
            }
        }
        //String composicion="Nombre: " + nombre + " Letra: " + letra + " Genero: " + strGenero;
        //return Optional.of(composicion);
        Cancion cancion = new Cancion(nombre, letra, genero);
        return cancionService.createCancion(cancion);
    }*/

    @PostMapping("/update/")
    public Optional<Cancion> update(@RequestBody Map<String, Object> requestBody){
        String letra= requestBody.get("letra").toString();
        Long id = parseLong(requestBody.get("id").toString());
        return cancionService.updateLetra(id,letra);
    }

    @GetMapping("/busqueda/nombre/{nombre}")
    public Optional<Cancion> searchCancionByNombre(@PathVariable String nombre){
        return cancionService.findByNombre(nombre);
    }

    @GetMapping("/busqueda/letra/{letra}")
    public Optional<Cancion> searchCancionByLetra(@PathVariable String letra){
        return cancionService.findByLetra(letra);
    }
}
