package com.Gimnasio.AplicacionGimnasio.repository;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface ClaseRepository extends CrudRepository<Clase,Long> {


    //Metodo encontrar todas las clases
    //No hay query porque esta en el crud
    Set<Clase> findAll();

    //Encontrar por ID
    Optional<Clase> findById(long id);
    //Busqueda por nombre
    //@Query("select c from Clase c where c.nombre = ?1")
    Clase findByNombre(String nombre);

    //Metodo que comprueba que en Reserva, en la Clase reservada si existe Capacidad
    //@Query("select (count(c) > 0) from Clase c inner join c.reservas reservas
    // where reservas.clase.capacidad = ?1")
    boolean existsByReservas_Clase_Capacidad(int capacidad);

    //Metodo que busca en reserva, la capacidad de la clase que se ha reservado.
    //@Query("select c from Clase c inner join c.reservas reservas where reservas.clase.capacidad = ?1")
    Integer findByReservas_Clase_Capacidad(int capacidad);
    //Metodo que borra por nombre
    //@Query("delete from Clase c where c.nombre = ?1")
    int deleteByNombre(String nombre);



}
