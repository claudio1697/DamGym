package com.Gimnasio.AplicacionGimnasio.repository;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClaseRepository extends CrudRepository<Clase,Long> {

    Set<Clase> findAll();


}
