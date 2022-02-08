package com.Gimnasio.AplicacionGimnasio.controller;


import com.Gimnasio.AplicacionGimnasio.domain.Reserva;
import com.Gimnasio.AplicacionGimnasio.excepcion.claseNotFoundException;
import com.Gimnasio.AplicacionGimnasio.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import java.util.Set;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    
    //Anyadiendo el @Operation calaudio
    @Operation(summary = "Registro de nueva Reserva en la app")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Se registra la reserva", content = @Content(schema =  @Schema(implementation = Reserva.class)))
    })
    //He hecho esto  @Sergio
    // RESERVA
    // OBTENER TODAS LAS CLASES
    // ANYADIR RESERVA (POST)
    @PostMapping(value ="/reserva", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Reserva> anyadirReserva(@RequestBody Reserva reserva){
        Reserva reservaAnyadida = reservaService.anyadirReservaBD(reserva);
        return new ResponseEntity<>(reservaAnyadida, HttpStatus.OK);
    }
     //Anyadiendo el @Operation calaudio
     @Operation(summary = "Obtiene lista de las reservas")
     @ApiResponses(value = {
         @ApiResponse(responseCode = "200", description = "Listado de reserva", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Reserva.class))))
     })     
    // OBTENER TODAS LAS RESERVAS
    @GetMapping(value = "/reserva", produces = "application/json")
    public ResponseEntity<Set<Reserva>> getProducts() {
        Set<Reserva> reserva = null;
        reserva = reservaService.findAll();
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
      //Anyadiendo el @Operation calaudio
      @Operation(summary = "Obtiene una reserva determinada")
      @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Existe la reserva", content = @Content(schema =  @Schema(implementation = Reserva.class))),
          @ApiResponse(responseCode = "404", description = "La reserva no existe", content = @Content(schema =  @Schema(implementation = Response.class)))
      })
    // BUSCAR RESERVA POR ID
    @GetMapping(value = "/reserva/{id}", produces = "application/json")
    public ResponseEntity<Reserva> getReservaId(@PathVariable long id) {
        Reserva reserva = reservaService.findById(id)
                .orElseThrow(() -> new claseNotFoundException(id));
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
     //Anyadiendo el @Operation calaudio
     @Operation(summary = "Modifica una reserva")
     @ApiResponses(value = {
         @ApiResponse(responseCode = "200", description ="Se modifico una reserva", content = @Content(schema = @Schema(implementation = Reserva.class))),
         @ApiResponse(responseCode = "404", description = "La resrva no existe", content = @Content(schema = @Schema(implementation = Response.class)))
     })
    // MODIFICAR RESERVA
    @PutMapping(value = "/reserva/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Reserva> modifyReserva(@PathVariable long id,
                                                 @RequestBody Reserva newReserva) {
        Reserva reserva = reservaService.modificarReserva(id, newReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }
    //Anyadiendo el @Operation calaudio
    @Operation(summary = "Elimina una reserva")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Se elimina una reserva", content = @Content(schema =  @Schema(implementation = Reserva.class))),
        @ApiResponse(responseCode = "404", description = "La reserva no existe", content = @Content(schema =  @Schema(implementation = Response.class)))
    })
    //BORRAR RESERVA
    @DeleteMapping(value = "/reserva/{id}", produces = "application/json")
    public void deleteReserva(@PathVariable long id){
        reservaService.deleteReserva(id);
    }





}
