package com.Gimnasio.AplicacionGimnasio.service;


import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import com.Gimnasio.AplicacionGimnasio.excepcion.reservaNotFoundExcepcion;
import com.Gimnasio.AplicacionGimnasio.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
@Service
@Transactional
public class ReservaServiceImp implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    @Override
    public Set<Reserva> findAll(){return reservaRepository.findAll();}

    @Override
    public Reserva anyadirReservaBD(Reserva reserva){return reservaRepository.save(reserva);}

    @Override
    public Reserva modificarReserva(long id, Reserva nueboReserva) {
        Reserva reserva =reservaRepository.findById(id)
                .orElseThrow(() -> new reservaNotFoundExcepcion(id, HttpStatus.NOT_FOUND));
        nueboReserva.setId(reserva.getId());
        return reservaRepository.save(nueboReserva);
    }
    // Metodo de busqueda por ID @Claudio
    @Override
    public Optional<Reserva> findById(long id){
        return reservaRepository.findById(id);
    }

    //Cambios que he realizado @Claudio
     @Override
    public void deleteReserva(long id) {
        reservaRepository.findById(id)
                .orElseThrow(() -> new reservaNotFoundExcepcion(id, HttpStatus.NOT_FOUND));
        reservaRepository.deleteById(id);
    }//Aqui termina los cambios que he realizado @Claudio

    //Metodo que coje las reservas que hay en clase.
    @Override
    public boolean findByClase_Reservas_Id(long id) {
        return reservaRepository.findByClase_Reservas_Id(id);
    }
}
