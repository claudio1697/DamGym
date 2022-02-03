package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import java.util.Optional;
import java.util.Set;

public interface ClienteService {
    Set<Cliente> findAll();

    // INTRODUCIR CLIENTE
    Cliente anyadirClienteBD(Cliente cliente);
    //ENCONTRAR POR ID
    Optional<Cliente> findById(long id);
    //MODIFICAR CLIENTE
    Cliente modificationeCLiente(long id, Cliente nueboCliente);
    //BORRAR CLIENTE
    Cliente deleteCliente(long id);
}
