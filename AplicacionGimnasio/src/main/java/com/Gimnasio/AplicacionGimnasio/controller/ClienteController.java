package com.Gimnasio.AplicacionGimnasio.controller;

import com.Gimnasio.AplicacionGimnasio.domain.Clase;
import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import com.Gimnasio.AplicacionGimnasio.excepcion.claseNotFoundException;
import com.Gimnasio.AplicacionGimnasio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    
    // ANYADIR CLIENTE
    @PostMapping("/cliente")
    public ResponseEntity<Cliente> anyadirCliente(@RequestBody Cliente cliente){

        Cliente clienteAnyadido = clienteService.anyadirClienteBD(cliente);
        return new ResponseEntity<>(clienteAnyadido, HttpStatus.OK);
    }

    //BUCAR TODOS LOS CLIENTES
    @GetMapping("/cliente")
    public ResponseEntity<Set<Cliente>> getCliente() {
        Set<Cliente> cliente = null;
        cliente = clienteService.findAll();
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }


    // BUSCAR CLASE POR ID
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteId(@PathVariable long id) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new claseNotFoundException(id));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    
     // MODIFICAR CLIENTE PUT
    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> modifyClient(@PathVariable long id,@RequestBody Cliente clienteModificado){
        Cliente cliente = clienteService.modifyCliente(id,clienteModificado);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }

    // ELIMINAR CLIENTE
    @DeleteMapping("/cliente/{id}")
    public void deleteClient(@PathVariable long id){clienteService.deleteCliente(id);}





}
