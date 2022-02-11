package com.Gimnasio.AplicacionGimnasio.repository;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface ClaseRepository extends CrudRepository<Clase,Long> {

    Set<Clase> findAll();


    Optional<Clase> findById(long id);


    boolean existsByReservas_Clase_Capacidad(int capacidad);


    Integer findByReservas_Clase_Capacidad(int capacidad);



}
