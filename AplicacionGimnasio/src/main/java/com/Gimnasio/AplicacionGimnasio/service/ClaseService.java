package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;

import java.util.Set;

public interface ClaseService {

    // BUSCAMOS POR TODAS LAS CLASES
    Set<Clase> findAll();

    // INTRODUCIR CLASES
    Clase anyadirClaseBD(Clase clase);

    // MODIFICAR CLASES

    // BORRAR CLASES
    Cliente deleteCliente(long id);
	//// COMENTARIO PRUEBA ////
}
