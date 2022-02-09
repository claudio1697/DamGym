package com.Gimnasio.AplicacionGimnasio.domain;


import com.Gimnasio.AplicacionGimnasio.EntityResolver.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

@Entity(name = "clase")
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
    private List<Reserva> reservas = new ArrayList<>();

///QUIZA HAYA ERROR// @SERGIOABDOMINALES
//////////RELACIONES COMENTADAS POR POSIBLE ERROR//////////



    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
        this.id_clase = id_clase;
    }
}
