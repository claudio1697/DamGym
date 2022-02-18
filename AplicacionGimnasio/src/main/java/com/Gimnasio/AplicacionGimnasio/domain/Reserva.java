package com.Gimnasio.AplicacionGimnasio.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Repository
@ToString
@Entity
@Table(name="reserva")
//Esto arregla el json que sale {hibernateLazyInitializer} sin tener que salir
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codReserva", nullable = false)
    @Schema(description ="Identificador de la Reserva", example = "1", required = true)
    private Long id;
    @Column
    //El JSON no detectaba el formato de la fecha.
    //Añadiendo @Temporal y el tipo TIMESTAMP hace que se vean.
    @Temporal(TemporalType.TIMESTAMP)
    @Schema(description ="Fecha que hay disponible la reserva", example = "2022-02-16")
    private Date fecha;

    @Column
    //Esto settea el formato que hay para insertar
    @JsonFormat(pattern = "HH:mm:ss")
    @Schema(description ="Hora a la que se hace la reserva", example = "18:00:00")
    private LocalTime hora;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "clase_id")
    @ToString.Exclude
    private Clase clase;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    @ToString.Exclude
    private Cliente cliente;


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    


    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reserva reserva = (Reserva) o;
        return id != null && Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
