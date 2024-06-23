package com.example.demo.repository;

import com.example.demo.model.Artista;
import com.example.demo.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista,Long>{
    Optional<Artista> findById(Long id);
    @Query("select a from Artista a JOIN a.genero g where g = :genero")
    Optional<Artista> findByGenero(@Param("genero") String genero);
    Optional<Artista> findByPais(String pais);
    @Query("select a from Artista a JOIN a.instrumento i where i.nombre IN :instrumento")
    Optional<Artista> findArtistasByInstrumento(Set<String> instrumento);
    @Query("select a from Artista a WHERE " +
            "(YEAR(CURRENT_DATE) - YEAR(a.fechaNacimiento) - " +
            "(CASE WHEN MONTH(CURRENT_DATE) < MONTH(a.fechaNacimiento) OR " +
            "(MONTH(CURRENT_DATE) = MONTH(a.fechaNacimiento) AND DAY(CURRENT_DATE) < DAY(a.fechaNacimiento)) " +
            "THEN 1 ELSE 0 END)) = :edad")
    Optional<Artista> findByEdad(@Param("edad") Integer edad);
    @Query("select a from Artista a join a.disco d join d.cancion c where c IN :cancion")
    Optional<Artista> findByCancion(Set<Cancion> cancion);
    Optional<Artista> findByFechaFallecimientoIsNull();
    Optional<Artista> findByFechaFallecimientoIsNotNull();
}
