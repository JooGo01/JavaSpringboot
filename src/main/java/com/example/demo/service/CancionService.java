package com.example.demo.service;

import com.example.demo.model.Cancion;
import com.example.demo.model.User;
import com.example.demo.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {
    @Autowired
    private CancionRepository cancionRepository;

    public Optional<Cancion> findById(Long id){
        return cancionRepository.findById(id);
    }

    public Optional<Cancion> createCancion(Cancion p_cancion){
        cancionRepository.save(p_cancion);
        return null;
    }
    public List<Cancion> findAll(){
        return cancionRepository.findAll();
    }

    public Optional<Cancion> findByNombre(String nombre){
        return cancionRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Optional<Cancion> findByLetra(String letra){
        return cancionRepository.findByLetraContainingIgnoreCase(letra);
    }

    @Transactional
    public Optional<Cancion> updateLetra(Long id, String nuevaLetra) {
        Optional<Cancion> optionalCancion = cancionRepository.findById(id);
        if (optionalCancion.isPresent()) {
            Cancion cancion = optionalCancion.get();
            cancion.setLetra(nuevaLetra);
            cancionRepository.save(cancion);
            return cancionRepository.findById(id);
        } else {
            throw new RuntimeException("No se encontro cancion con id: " + id);
        }
    }
}
