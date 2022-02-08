package com.Gimnasio.AplicacionGimnasio.repository;


import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ReservaRepository extends CrudRepository<Reserva,Long> {
    Set<Reserva> findAll();
}
