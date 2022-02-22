package com.Gimnasio.AplicacionGimnasio.domain;


import com.Gimnasio.AplicacionGimnasio.EntityResolver.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * class que contiene los clientes del gimnasio
 * @Params dni, nombre apellidos direccion telefono
 */

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="cliente")
//Uso de la clase EntityIDResolver que coge el id de esta clase
//y permite mostrar los datos en el json
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        resolver = EntityIdResolver.class,
        scope=Cliente.class)
//Esto arregla el json que sale {hibernateLazyInitializer} sin tener que salir
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description ="Identificador de la Cliente", example = "1",required = true)
    private Long id;

    @Column
    @Schema(description ="Segundo identificador de la Cliente", example = "8954512X")
    private String dni;
    @Column
    @Schema(description ="Nombre del Cliente", example = "Juan")
    private String nombre;
    @Column
    @Schema(description = "Apellidos del Cliente", example = "Pablo Juanito")
    private String apellidos;
    @Column
    @Schema(description = "Direccion del sitio de donde vive el Cliente", example = "calle arriba españa")
    private String direccion;
    @Column
    @Schema(description = "Contacto del Cliente", example = "6969696969")
    private int telefono;

    @OneToMany(mappedBy = "cliente", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Reserva> reservas = new ArrayList<>();


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
