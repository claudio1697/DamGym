package com.Gimnasio.AplicacionGimnasio.controller;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import com.Gimnasio.AplicacionGimnasio.excepcion.claseNotFoundException;
import com.Gimnasio.AplicacionGimnasio.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    
    //He hecho esto  @Sergio
    // RESERVA
    // OBTENER TODAS LAS CLASES

    // ANYADIR RESERVA (POST)
    @PostMapping("/reserva")
    public ResponseEntity<Reserva> anyadirReserva(@RequestBody Reserva reserva){
        Reserva reservaAnyadida = reservaService.anyadirReservaBD(reserva);
        return new ResponseEntity<>(reservaAnyadida, HttpStatus.OK);
    }

    // OBTENER TODAS LAS RESERVAS
    @GetMapping("/reserva")
    public ResponseEntity<Set<Reserva>> getProducts() {
        Set<Reserva> reserva = null;
        reserva = reservaService.findAll();
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    // BUSCAR RESERVA POR ID
    @GetMapping("/reserva/{id}")
    public ResponseEntity<Reserva> getReservaId(@PathVariable long id) {
        Reserva reserva = reservaService.findById(id)
                .orElseThrow(() -> new claseNotFoundException(id));
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    // MODIFICAR RESERVA
    @PutMapping("/reserva/{id}")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long id,
                                                 @RequestBody Reserva newReserva) {
        Reserva reserva = reservaService.modificarReserva(id, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    //BORRAR RESERVA
    @DeleteMapping("/reserva/{id}")
    public void deleteReserva(@PathVariable long id){
        reservaService.deleteReserva(id);
    }





}
