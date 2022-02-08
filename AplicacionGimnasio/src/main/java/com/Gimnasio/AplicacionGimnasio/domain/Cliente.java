package com.Gimnasio.AplicacionGimnasio.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dni;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private String direccion;
    @Column
    private int telefono;
////////RELACIONES COMENTADAS POR ERROR/////////
    //Variable emf que se encarga de organizar las relaciones
 //   private static EntityManagerFactory emf;
    //Relacion de 1 a muchos de clientes a Reserva
    @OneToMany(mappedBy = "clientes", cascade = CascadeType.PERSIST)
    //Sacamos la lista del ToString de aqui
    private List<Reserva> reservasList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
