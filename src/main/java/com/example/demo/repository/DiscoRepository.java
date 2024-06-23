package com.example.demo.repository;

import com.example.demo.model.Disco;
import com.example.demo.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {
    Optional<Disco> findById(Long id);
    Set<Disco> findByNombreContainingIgnoreCase(String nombre);
    @Query("Select d from Disco d join d.genero g where g = :genero")
    Set<Disco> findByGenero(@Param("genero") Genero genero);
    Set<Disco> findByFechaLanzamiento(Date fecha);

}
