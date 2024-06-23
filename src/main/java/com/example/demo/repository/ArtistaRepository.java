package com.example.demo.repository;

import com.example.demo.model.Artista;
import com.example.demo.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista,Long>{
    Optional<Artista> findByID(Long id);
    Optional<Artista> findByGenero(String genero);
    Optional<Artista> findByNacionalidad(String nacionalidad);
    Optional<Artista> findByInstrumento(String instrumento);
    Optional<Artista> findByEdad(Long edad);
    Optional<Artista> findByCancion(Cancion cancion);
    Optional<Artista> findByVivo();
    Optional<Artista> findByFallecido();
}
