package com.Gimnasio.AplicacionGimnasio.controller;

import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import com.Gimnasio.AplicacionGimnasio.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    
    //He hecho esto  @Sergio
    // RESERVA
    // OBTENER TODAS LAS CLASES
    @GetMapping("/reserva")
    public ResponseEntity<Set<Reserva>> getProducts() {
        Set<Reserva> reserva = null;
        reserva = reservaService.findAll();
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
    //hasta aqui
    
    // ANYADIR RESERVA (POST)

    @PostMapping("/reserva")
    public ResponseEntity<Reserva> anyadirReserva(@RequestBody Reserva reserva){

        Reserva reservaAnyadida = reservaService.anyadirReservaBD(reserva);
        return new ResponseEntity<>(reservaAnyadida, HttpStatus.OK);


    }



}
