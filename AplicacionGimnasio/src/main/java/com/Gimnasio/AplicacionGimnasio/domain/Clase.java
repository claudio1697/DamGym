package com.Gimnasio.AplicacionGimnasio.domain;


import com.Gimnasio.AplicacionGimnasio.EntityResolver.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * class que contiene las Clases del gimnasio
 * @Params ubicación, nombre monitor capacidad(int) description
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Repository
@ToString
@Entity
@Table(name = "clase")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_clase",
        resolver = EntityIdResolver.class,
        scope=Clase.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id_clase;

    @Column
    private String ubicacion;
    @Column
    private String nombre;
    @Column
    private int capacidad;
    @Column
    private String monitor;
    @Column
    private String descripcion;

    @OneToMany(mappedBy = "clase", orphanRemoval = true, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Reserva> reservas = new ArrayList<>();

///QUIZA HAYA ERROR// @SERGIOABDOMINALES
//////////RELACIONES COMENTADAS POR POSIBLE ERROR//////////


    public int getCapacidad() {
        return capacidad;
    }

    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
        this.id_clase = id_clase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Clase clase = (Clase) o;
        return id_clase != null && Objects.equals(id_clase, clase.id_clase);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
