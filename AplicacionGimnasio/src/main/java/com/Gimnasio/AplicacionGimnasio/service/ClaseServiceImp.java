package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
@Service
@Transactional
public class ClaseServiceImp implements ClaseService{

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public Set<Clase> findAll() {
        return claseRepository.findAll();
    }

    @Override
    public Clase anyadirClaseBD(Clase clase){
        return claseRepository.save(clase);
    }

    // Añadido metodo de borrado cliente @Fede
    @Override
    public void deleteCliente(long id) {
        claseRepository.findById(id)
                .orElseThrow(() -> new claseNotFoundExcepcion(id));
        claseRepository.deleteById(id);
    }
}
