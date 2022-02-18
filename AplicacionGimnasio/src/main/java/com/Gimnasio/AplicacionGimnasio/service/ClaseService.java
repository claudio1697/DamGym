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
    long deleteByNombre(String nombre);
    //BUSQUEDA POR NOMBRE
    Clase findByNombre(String nombre);
    //COMPRUEBA SI EXISTE LA CLASE EN LA TABLA RESERVA
    boolean existsByReservas_Clase_Capacidad(int id);
    //BUSQUEDA EN RESERVA DE LA COLUMNA DE CLASE CAPACIDAD
    Integer findByReservas_Clase_Capacidad(int id);

}
