package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.domain.Reserva;

import java.util.Set;

public interface ReservaService {

    Set<Reserva> findAll();
    Reserva anyadirReservaBD(Reserva reserva);
    Reserva modificationeReserva(long id, Reserva reserva);
    //Cambios que he realizado @Claudio
    void deleteReserva(long id);
}
