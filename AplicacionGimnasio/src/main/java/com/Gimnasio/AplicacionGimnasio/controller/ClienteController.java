package com.Gimnasio.AplicacionGimnasio.controller;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import com.Gimnasio.AplicacionGimnasio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    //He hecho esto @Sergio
    //BUCAR CLIENTE
    @GetMapping("/cliente")
    public ResponseEntity<Set<Cliente>> getCliente() {
        Set<Cliente> cliente = null;
        cliente = clienteService.findAll();
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    //hasta aqui
    
    // ANYADIR CLIENTE
    @PostMapping("/cliente")
    public ResponseEntity<Cliente> anyadirCliente(@RequestBody Cliente cliente){

        Cliente clienteAnyadido = clienteService.anyadirClienteBD(cliente);
        return new ResponseEntity<>(clienteAnyadido, HttpStatus.OK);
    }

}
