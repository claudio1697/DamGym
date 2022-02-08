package com.Gimnasio.AplicacionGimnasio.controller;


import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.excepcion.claseNotFoundException;
import com.Gimnasio.AplicacionGimnasio.service.ClaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
        @ApiResponse(responseCode = "200", description = "Se registra la clase", content = @Content(schema =  @Schema(implementation = Clase.class)))
    })
   //He hecho esto @Sergio
    // ANYADIR CLASES (POST)
    @PostMapping(value = "/clase", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Clase> anyadirClase(@RequestBody Clase clase){
        Clase claseAnyadida = claseService.anyadirClaseBD(clase);
        return new ResponseEntity<>(claseAnyadida, HttpStatus.OK);
    }
     //Anyadiendo el @Operation calaudio
     @Operation(summary = "Obtiene lista de las mesas")
     @ApiResponses(value = {
         @ApiResponse(responseCode = "200", description = "Listado de clases", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Clase.class))))
     })     
    // OBTENER TODAS LAS CLASES
    @GetMapping(value = "/clase", produces = "application/json")
    public ResponseEntity<Set<Clase>> getProducts() {
        Set<Clase> clase = null;
        clase = claseService.findAll();
        return new ResponseEntity<>(clase, HttpStatus.OK);
    }
    //Anyadiendo el @Operation calaudio
    @Operation(summary = "Obtiene una clase determinada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Existe la clase", content = @Content(schema =  @Schema(implementation = Clase.class))),
        @ApiResponse(responseCode = "404", description = "La clase no existe", content = @Content(schema =  @Schema(implementation = Response.class)))
    })
    // BUSCAR CLASE POR ID
    @GetMapping("/clase/{id}")
    public ResponseEntity<Clase> getClaseId(@PathVariable long id) {
        Clase clase = claseService.findById(id)
                .orElseThrow(() -> new claseNotFoundException(id));
        return new ResponseEntity<>(clase, HttpStatus.OK);
    }
    //Anyadiendo el @Operation calaudio
    @Operation(summary = "Modifica una clase")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description ="Se modifico una clase", content = @Content(schema = @Schema(implementation = Clase.class))),
        @ApiResponse(responseCode = "404", description = "La clase no existe", content = @Content(schema = @Schema(implementation = Response.class)))
    })
    // MODIFICAR CLASE ( PUT)
    // metodo creado Sergio
    @PutMapping( value = "/clase/{id_clase}",produces ="application/json", consumes = "application/json")
    public ResponseEntity<Clase> modifyClase(@PathVariable long id_clase,@RequestBody Clase claseModificada){
        Clase clase = claseService.modificarClase(id_clase,claseModificada);
        return new ResponseEntity<>(clase,HttpStatus.OK);
    }
    //Anyadiendo el @Operation calaudio
    @Operation(summary = "Elimina una clase")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Se elimina una clase", content = @Content(schema =  @Schema(implementation = Clase.class))),
        @ApiResponse(responseCode = "404", description = "La clase no existe", content = @Content(schema =  @Schema(implementation = Response.class)))
    })
    // BORRAR CLASE
    @DeleteMapping(value ="/clase/{id}", produces = "application/json")
    public void deleteClase(@PathVariable long id){
        claseService.deleteClase(id);
    }







}
