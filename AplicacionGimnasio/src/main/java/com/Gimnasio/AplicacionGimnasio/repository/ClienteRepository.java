package com.Gimnasio.AplicacionGimnasio.repository;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {

    //Busqueda de Cliente por DNI
    //@Query("select c from Cliente c where c.dni = ?1")
    Cliente findByDni(String dni);

    //Busqueda de todos los clientes
    Set<Cliente> findAll();


    //@Query("delete from Cliente c where c.dni = ?1")
    void deleteByDni(String dni);


}
