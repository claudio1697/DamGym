package com.Gimnasio.AplicacionGimnasio.domain;


import com.Gimnasio.AplicacionGimnasio.EntityResolver.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="cliente")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope=Cliente.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @OneToMany(mappedBy = "cliente", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Reserva> reservas = new ArrayList<>();

////////RELACIONES COMENTADAS POR ERROR/////////
    //Variable emf que se encarga de organizar las relaciones
 //   private static EntityManagerFactory emf;
    //Relacion de 1 a muchos de clientes a Reserva



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cliente cliente = (Cliente) o;
        return id != null && Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
