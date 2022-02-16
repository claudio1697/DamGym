package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Reserva;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.Set;


public interface ReservaService {


    // CREAR RESERVA
    Reserva anyadirReservaBD(Reserva reserva);

    //BUSCAR TODAS LAS RESERVAS
    Set<Reserva> findAll();

    // BUSCAR POR ID
    Optional<Reserva> findById(long id);

    //MODIFICAR RESERVAS
    Reserva modificarReserva(long id, Reserva reserva);

    //ELIMINAR RESERVA
    void deleteReserva(long id);

    boolean existsByIdIsNull();

    long countByClase_Reservas_Id(long id);

    long countByCliente_Id(long id);


    long countDistinctByFechaAndHora(Date fecha, LocalTime hora);



}
