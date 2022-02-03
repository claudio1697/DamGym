package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;

import java.util.Optional;
import java.util.Set;

public interface ClaseService {

    // INTRODUCIR CLASES
    Clase anyadirClaseBD(Clase clase);

    // BUSCAMOS POR TODAS LAS CLASES
    Set<Clase> findAll();

     // BUSCAR POR ID @Sergio
    Optional<Clase> findById(long id);
	
    // MODIFICAR CLASES
    Clase modificarClase(long id, Clase nuevaClase);

    // BORRAR CLASES
    void deleteClase(long id);
	//// COMENTARIO PRUEBA ////
}
