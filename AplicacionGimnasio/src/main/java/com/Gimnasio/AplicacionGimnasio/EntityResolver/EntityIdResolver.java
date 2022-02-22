package com.Gimnasio.AplicacionGimnasio.EntityResolver;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;

import javax.persistence.EntityManager;

//Esta clase coge el ID que se inserta y busca toda la informacion de ese ID
// de la Clase Y de Cliente si existe.
public class EntityIdResolver
        implements ObjectIdResolver {

    private final EntityManager entityManager;

    public EntityIdResolver(
            final EntityManager entityManager) {

        this.entityManager = entityManager;

    }

    @Override
    public void bindItem(
            final ObjectIdGenerator.IdKey id,
            final Object pojo) {
    }

    @Override
    public Object resolveId(final ObjectIdGenerator.IdKey id) {

        return this.entityManager.find(id.scope, id.key);
    }
    //Si funciona devuelve la clase con todas las cosas
    @Override
    public ObjectIdResolver newForDeserialization(final Object context) {

        return this;
    }
    //Si no funciona da falso
    @Override
    public boolean canUseFor(final ObjectIdResolver resolverType) {

        return false;
    }

}
