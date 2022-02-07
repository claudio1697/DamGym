package com.Gimnasio.AplicacionGimnasio.controller;


import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.excepcion.claseNotFoundException;
import com.Gimnasio.AplicacionGimnasio.service.ClaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController

public class ClaseController {

    @Autowired
    private ClaseService claseService;

   //Anyadiendo el @Operation calaudio
    @Operation(summary = "Registro de nueva Clase en la app")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Se registra la clase", content = @Content)
    })
   //He hecho esto @Sergio
    // ANYADIR CLASES (POST)
    @PostMapping(value = "/clase", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Clase> anyadirClase(@RequestBody Clase clase){
        Clase claseAnyadida = claseService.anyadirClaseBD(clase);
        return new ResponseEntity<>(claseAnyadida, HttpStatus.OK);
    }

    // OBTENER TODAS LAS CLASES
    @GetMapping("/clase")
    public ResponseEntity<Set<Clase>> getProducts() {
        Set<Clase> clase = null;
        clase = claseService.findAll();
        return new ResponseEntity<>(clase, HttpStatus.OK);
    }

    // BUSCAR CLASE POR ID
    @GetMapping("/clase/{id}")
    public ResponseEntity<Clase> getClaseId(@PathVariable long id) {
        Clase clase = claseService.findById(id)
                .orElseThrow(() -> new claseNotFoundException(id));
        return new ResponseEntity<>(clase, HttpStatus.OK);
    }

    // MODIFICAR CLASE ( PUT)
    // metodo creado Sergio
    @PutMapping("/clase/{id_clase}")
    public ResponseEntity<Clase> modifyClase(@PathVariable long id_clase,@RequestBody Clase claseModificada){
        Clase clase = claseService.modificarClase(id_clase,claseModificada);
        return new ResponseEntity<>(clase,HttpStatus.OK);
    }

    // BORRAR CLASE
    @DeleteMapping("/clase/{id}")
    public void deleteClase(@PathVariable long id){
        claseService.deleteClase(id);
    }







}
