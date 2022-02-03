package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.excepcion.claseNotFoundException;
import com.Gimnasio.AplicacionGimnasio.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
@Service
@Transactional
public class ClaseServiceImp implements ClaseService{

    @Autowired
    private ClaseRepository claseRepository;

    // BUSCAR TODOS
    @Override
    public Set<Clase> findAll() {
        return claseRepository.findAll();
    }

    //  BUSCAR POR ID
    @Override
    public Optional<Clase> findById(long id){
        return claseRepository.findById(id);
    }

    @Override
    public Clase anyadirClaseBD(Clase clase){
        return claseRepository.save(clase);
    }
    //He añadido el metodo modificar Clase @Sergio

    @Override
    public Clase modificarClase(long id_clase,Clase nuevaClase){

        Clase clase = claseRepository.findById(id_clase).orElseThrow(() -> new claseNotFoundException(id_clase));
       // nuevaClase.setId_clase(clase.getId_clase());
        nuevaClase.setId_clase(clase.getId_clase());
        return claseRepository.save(nuevaClase);

    }//hasta aqui
    
    // Añadido metodo de borrado cliente @Fede
    @Override
    public void deleteClase(long id) {
        claseRepository.findById(id)
                .orElseThrow(() -> new claseNotFoundException(id));
        claseRepository.deleteById(id);
    }
}
