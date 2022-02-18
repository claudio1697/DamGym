package com.Gimnasio.AplicacionGimnasio.repository;


import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

public interface ReservaRepository extends CrudRepository<Reserva,Long> {



    //Comprueba si existe la reserva por el ID introducido
    //Sino existe, crea el ID introducido
    //@Query("select (count(r) > 0) from Reserva r where r.id is null")
    boolean existsByIdIsNull();

    //Cuenta la fecha y la hora y se compara con la capacidad de la Clase
    //y si no supera la capacidad se introcue,
    //CUENTA A PARTIR DE 0.
    //@Query("select count(distinct r) from Reserva r where r.fecha = ?1 and r.hora = ?2")
    long countDistinctByFechaAndHora(Date fecha, LocalTime hora);

    //Metodo que busca todas las reservas
    Set<Reserva> findAll();


    //Cuenta por el ID de cliente
    //@Query("select count(r) from Reserva r where r.cliente.id = ?1")
    long countByCliente_Id(long id);
    //Cuenta las reservas que tiene la clase
    //@Query("select count(r) from reserva r inner join r.clase.reservas reservas where reservas.id = ?1")
    long countByClase_Reservas_Id(long id);




}
