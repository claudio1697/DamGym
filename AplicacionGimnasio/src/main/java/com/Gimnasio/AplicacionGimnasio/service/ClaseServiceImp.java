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
    //He añadido el metodo modificar Clase @Sergio
    @Override
    public Clase modificarClase(long id_clase,Clase newClase){

        Clase clase = claseRepository.findById(id_clase).orElseThrow(() -> new claseNotFoundException(id_clase));
        newClase.setId_clase(clase.getId_clase());
        return claseRepository.save(newClase);

    }//hasta aqui
    
    // Añadido metodo de borrado cliente @Fede
    @Override
    public void deleteCliente(long id) {
        claseRepository.findById(id)
                .orElseThrow(() -> new claseNotFoundExcepcion(id));
        claseRepository.deleteById(id);
    }
}
