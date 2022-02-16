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
    public Cliente modificarCliente(String dni, Cliente nuevoCliente) {
        Cliente cliente =clienteRepository.findByDni(dni);
        nuevoCliente.setDni(cliente.getDni());
        return clienteRepository.save(nuevoCliente);
    }

    // Añadido metodo de borrado cliente @Fede
    @Override
    public void deleteCliente(long id) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new clienteNotFoundExcepcion(id));
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente findByDni(String dni) {
      return clienteRepository.findByDni(dni);
    }

    @Override
    public void deleteByDni(String dni) {
        clienteRepository.findByDni(dni).getDni();

        clienteRepository.deleteByDni(dni);
    }


}
