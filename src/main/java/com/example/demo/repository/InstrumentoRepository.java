package com.example.demo.repository;

import com.example.demo.model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {
    Optional<Instrumento> findByNombre(String nombre);
    Optional<Instrumento> findById(Long id);
}
