package com.Gimnasio.AplicacionGimnasio.service;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import com.Gimnasio.AplicacionGimnasio.excepcion.clienteNotFoundExcepcion;
import com.Gimnasio.AplicacionGimnasio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;



@Service
@Transactional
public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Set<Cliente> findAll() {
        return clienteRepository.findAll();
    }


    @Override
    public Cliente anyadirClienteBD(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> findById(long id){
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente modificarCliente(long id, Cliente nueboCliente) {
        Cliente cliente =clienteRepository.findById(id)
                .orElseThrow(() -> new clienteNotFoundExcepcion(id));
        nueboCliente.setId(cliente.getId());
        return clienteRepository.save(nueboCliente);
    }

    // Añadido metodo de borrado cliente @Fede
    @Override
    public void deleteCliente(long id) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new clienteNotFoundExcepcion(id));
        clienteRepository.deleteById(id);
    }


}
