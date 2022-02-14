package com.Gimnasio.AplicacionGimnasio.repository;


import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ReservaRepository extends CrudRepository<Reserva,Long> {
    Set<Reserva> findAll();

    boolean findByClase_Reservas_Id(Long id);

    
    long countByClase_Reservas_Id(Long id);



}
