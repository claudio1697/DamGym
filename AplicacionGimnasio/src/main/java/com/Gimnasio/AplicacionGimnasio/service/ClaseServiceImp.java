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
public class ClaseServiceImp implements ClaseService {

    @Autowired
    private final ClaseRepository claseRepository;


    public ClaseServiceImp(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    // BUSCAR TODOS
    @Override
    public Set<Clase> findAll() {
        return claseRepository.findAll();
    }

    //  BUSCAR POR ID
    @Override
    public Optional<Clase> findById(long id) {
        return claseRepository.findById(id);
    }

    @Override
    public Clase anyadirClaseBD(Clase clase) {
        return claseRepository.save(clase);
    }


    @Override
    public Clase modificarClase(long id_clase, Clase nuevaClase) {

        Clase clase = claseRepository.findById(id_clase).orElseThrow(() -> new claseNotFoundException(id_clase));

        nuevaClase.setId_clase(clase.getId_clase());

        return claseRepository.save(nuevaClase);

    }//hasta aqui

   
    @Override
    public long deleteByNombre(String nombre) {return claseRepository.deleteByNombre(nombre);}

    @Override
    public Clase findByNombre(String nombre) {
        return claseRepository.findByNombre(nombre);
    }

    @Override
    public boolean existsByReservas_Clase_Capacidad(int id) {
        return claseRepository.existsByReservas_Clase_Capacidad(id);
    }

    @Override
    public Integer findByReservas_Clase_Capacidad(int id) {
        return claseRepository.findByReservas_Clase_Capacidad(id);
    }




}

