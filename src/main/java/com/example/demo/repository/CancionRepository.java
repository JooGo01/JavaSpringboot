package com.example.demo.repository;

import com.example.demo.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CancionRepository extends JpaRepository<Cancion,Long> {
    Optional<Cancion> findByLetraContainingIgnoreCase(String letra);

    Optional<Cancion> findByNombreContainingIgnoreCase(String nombre);
}
