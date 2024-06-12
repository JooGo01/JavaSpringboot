package com.example.demo.controller;

import com.example.demo.model.Cancion;
import com.example.demo.model.Genero;
import com.example.demo.model.User;
import com.example.demo.service.CancionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<Cancion> create(@RequestBody Map<String, Object> requestBody){
        String nombre = requestBody.get("nombre").toString();
        String letra= requestBody.get("letra").toString();
        String strGenero= requestBody.get("genero").toString();
        Genero genero;
        if(Genero.existe(strGenero)){
            genero = Genero.fromString(strGenero);
        }else{
             genero = Genero.Clásica;
        }
        //String composicion="Nombre: " + nombre + " Letra: " + letra + " Genero: " + strGenero;
        //return Optional.of(composicion);
        Cancion cancion = new Cancion(nombre, letra, genero.toString());
        return cancionService.createCancion(cancion);
    }

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
