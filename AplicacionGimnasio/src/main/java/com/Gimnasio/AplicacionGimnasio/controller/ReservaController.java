package com.Gimnasio.AplicacionGimnasio.controller;


import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import com.Gimnasio.AplicacionGimnasio.excepcion.reservaNotFoundExcepcion;
import com.Gimnasio.AplicacionGimnasio.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.Set;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    private static int contador = 0;
    private EntityManager entityManager;
    private static int capacidad;
    private Clase clase;


    @Operation(summary = "Registro de nueva Reserva en la app")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se registra la reserva", content = @Content(schema = @Schema(implementation = Reserva.class)))
    })

    // RESERVA
    // OBTENER TODAS LAS CLASES
    // ANYADIR RESERVA (POST)
    @PostMapping(value = "/reserva", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Reserva> anyadirReserva(@RequestBody Reserva reserva){

        if(!reservaService.existsByIdIsNull()) {
            long num = reservaService.countDistinctByFechaAndHora(reserva.getFecha(), reserva.getHora());
            if (num < reserva.getClase().getCapacidad()-1) {
                Reserva reservaAnyadida = reservaService.anyadirReservaBD(reserva);
                System.out.println("EL NUMERO DE RESERVAD HECHAS A ESTA CLASE: " + num);
                System.out.println("LIMITE DE RESERVAS ES:" + reserva.getClase().getCapacidad());
                return new ResponseEntity<>(reservaAnyadida, HttpStatus.OK);
            } else {
               Reserva aux = new Reserva(1L,null,null,null,null);
               return new ResponseEntity<>(aux,HttpStatus.OK);
            }
        }else{
            Reserva reservaAnyadida = reservaService.anyadirReservaBD(reserva);
            return new ResponseEntity<>(reservaAnyadida, HttpStatus.OK);
        }
    }


        @Operation(summary = "Obtiene lista de las reservas")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Listado de reserva", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reserva.class))))
        })
        // OBTENER TODAS LAS RESERVAS

        @GetMapping(value = "/reserva", produces = "application/json")
        public ResponseEntity<Set<Reserva>> getProducts () {
            Set<Reserva> reserva;
            reserva = reservaService.findAll();
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        }

        @Operation(summary = "Obtiene una reserva determinada")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Existe la reserva", content = @Content(schema = @Schema(implementation = Reserva.class))),
                @ApiResponse(responseCode = "404", description = "La reserva no existe", content = @Content(schema = @Schema(implementation = Response.class)))
        })
        // BUSCAR RESERVA POR ID
        @GetMapping(value = "/reserva/{id}", produces = "application/json")
        public ResponseEntity<Reserva> getReservaId ( @PathVariable long id){
            Reserva reserva = reservaService.findById(id)
                    .orElseThrow(() -> new reservaNotFoundExcepcion(id, HttpStatus.NOT_FOUND));
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        }


        @Operation(summary = "Modifica una reserva")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Se modifico una reserva", content = @Content(schema = @Schema(implementation = Reserva.class))),
                @ApiResponse(responseCode = "404", description = "La resrva no existe", content = @Content(schema = @Schema(implementation = Response.class)))
        })
        // MODIFICAR RESERVA
        @PutMapping(value = "/reserva/{id}", produces = "application/json", consumes = "application/json")
        public ResponseEntity<Reserva> modifyReserva ( @PathVariable int id,
        @RequestBody Reserva newReserva){


            Reserva reserva = reservaService.modificarReserva(id, newReserva);
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        }

        @Operation(summary = "Elimina una reserva")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Se elimina una reserva", content = @Content(schema = @Schema(implementation = Reserva.class))),
                @ApiResponse(responseCode = "404", description = "La reserva no existe", content = @Content(schema = @Schema(implementation = Response.class)))
        })
        //BORRAR RESERVA
        @DeleteMapping(value = "/reserva/{id}", produces = "application/json")
        public void deleteReserva ( @PathVariable long id){
            reservaService.deleteReserva(id);
            if (contador > 0) {
                contador--;
            }
        }





}


