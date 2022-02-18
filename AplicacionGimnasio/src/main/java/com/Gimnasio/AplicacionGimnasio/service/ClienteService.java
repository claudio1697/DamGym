package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import java.util.Optional;
import java.util.Set;

public interface ClienteService {

    // BUSCAMOS POR TODAS LAS CLASES
    Set<Cliente> findAll();

    // INTRODUCIR CLIENTE
    Cliente anyadirClienteBD(Cliente cliente);

    // ENCONTRAR POR ID
    Optional<Cliente> findById(long id);

    // MODIFICAR CLIENTE
    Cliente modificarCliente(String dni, Cliente nuevoCliente);

    // BORRAR CLIENTE
    void deleteCliente(long id);

    //Encontrar por DNI
    Cliente findByDni(String dni);
    //BORRAR POR DNI
    void deleteByDni(String dni);
}
