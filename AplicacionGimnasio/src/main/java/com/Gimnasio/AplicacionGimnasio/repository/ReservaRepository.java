package com.Gimnasio.AplicacionGimnasio.repository;


import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ReservaRepository extends CrudRepository<Reserva,Long> {


    boolean existsByIdIsNull();


    long countByHora(LocalTime hora);

    Set<Reserva> findAll();


    long countByCliente_Id(long id);

    //@Query("select count(r) from reserva r inner join r.clase.reservas reservas where reservas.id = ?1")
    long countByClase_Reservas_Id(long id);




}
