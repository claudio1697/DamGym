package com.Gimnasio.AplicacionGimnasio.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codReserva", nullable = false)
    private Long id;
    @Column
    private Date fecha;

    @Column
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hora;

//////////RELACIONES COMENTADAS POR POSIBLE ERROR//////////
    //Variable emf que se encarga de organizar las relaciones
   // private static EntityManagerFactory emf;
    //Relacion de Muchas reservas a un cliente
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    //Llamada para finalizar la relacion Cliente-Reserva
    private Cliente clientes;

    //Relacion de muchos a 1 de Reserva-Clase
    @ManyToOne(fetch = FetchType.LAZY)
    private Clase clase;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
