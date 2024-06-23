package com.example.demo.service;

import com.example.demo.model.Instrumento;
import com.example.demo.repository.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class InstrumentoService {
    @Autowired
    private InstrumentoRepository instrumentoRepository;

    public Optional<Instrumento> createInstrumento(Instrumento instrumento){
        instrumentoRepository.save(instrumento);
        return null;
    }

    public Optional<Instrumento> findById(Long id){
        return instrumentoRepository.findById(id);
    }

    public Optional<Instrumento> findByNombre(String nombre){
        return instrumentoRepository.findByNombre(nombre);
    }
}
