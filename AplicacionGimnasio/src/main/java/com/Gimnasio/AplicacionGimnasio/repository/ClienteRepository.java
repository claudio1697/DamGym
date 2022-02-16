package com.Gimnasio.AplicacionGimnasio.repository;

import com.Gimnasio.AplicacionGimnasio.domain.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface ClienteRepository extends CrudRepository<Cliente,Long> {

    Cliente findByDni(String dni);

    Set<Cliente> findAll();

  //  @Transactional
    //@Modifying
    //@Query("delete from Cliente c where c.dni = ?1")
    void deleteByDni(String dni);


}
