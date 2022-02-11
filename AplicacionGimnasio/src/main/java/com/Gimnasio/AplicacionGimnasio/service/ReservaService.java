package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Reserva;

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

    boolean findByClase_Reservas_Id(long id);

}
