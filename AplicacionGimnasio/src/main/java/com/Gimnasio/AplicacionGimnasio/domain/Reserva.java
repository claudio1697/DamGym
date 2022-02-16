package com.Gimnasio.AplicacionGimnasio.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codReserva", nullable = false)
    private Long id;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column
    @JsonFormat(pattern = "HH:mm:ss")
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
