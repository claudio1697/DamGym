package com.Gimnasio.AplicacionGimnasio.repository;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {

    Set<Cliente> findAll();
}
