package com.Gimnasio.AplicacionGimnasio.controller;


import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController

public class ClaseController {

    @Autowired
    private ClaseService claseService;
    
   //He hecho esto @Sergio
    // OBTENER TODAS LAS CLASES
    @GetMapping("/clase")
    public ResponseEntity<Set<Clase>> getProducts() {
        Set<Clase> clase = null;
            clase = claseService.findAll();
        return new ResponseEntity<>(clase, HttpStatus.OK);
    }
    //hasta aqui



    // ANYADIR CLASES (POST)
    @PostMapping("/clase")
    public ResponseEntity<Clase> anyadirClase(@RequestBody Clase clase){
        Clase claseAnyadida = claseService.anyadirClaseBD(clase);
        return new ResponseEntity<>(claseAnyadida, HttpStatus.OK);
    }
    
    // MODIFICAR CLASE ( PUT)
    // metodo creado Sergio
    @PutMapping("/clase/{id_clase}")
    public ResponseEntity<Clase> modifyClase(@PathVariable long id_clase,@RequestBody Clase claseModificada){
        Clase clase = claseService.modificarClase(id_clase,claseModificada);
        return new ResponseEntity<>(clase,HttpStatus.OK);

    }





}
