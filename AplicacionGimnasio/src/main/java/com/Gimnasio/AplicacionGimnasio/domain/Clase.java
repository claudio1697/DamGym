package com.Gimnasio.AplicacionGimnasio.domain;


import com.Gimnasio.AplicacionGimnasio.EntityResolver.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
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
//Uso de la clase EntityIDResolver que coge el id de esta clase
//y permite mostrar los datos en el json
//Como un get de PostMan
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_clase",
        resolver = EntityIdResolver.class,
        scope=Clase.class)
//Esto arregla el json que sale {hibernateLazyInitializer} sin tener que salir
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Schema(description ="Identificador de la clase", example = "1",required = true)
    private Long id_clase;

    @Column
    @Schema(description ="Ubicacion de la clase", example = "Sala 1")
    private String ubicacion;
    @Column
    @Schema(description ="Nombre de la clase", example = "Spinning")
    private String nombre;
    @Column
    @Schema(description ="Numero de personas por clase", example = "5")
    private int capacidad;
    @Column
    @Schema(description ="Nombre del monitor de esa clase", example = "Juan")
    private String monitor;
    @Column
    @Schema(description ="Descripcion de la clase", example = "Cardio en bicicleta")
    private String descripcion;

    @OneToMany(mappedBy = "clase", orphanRemoval = true, cascade = CascadeType.ALL)
    //Esto excluye la lista del to string de reservas
    @ToString.Exclude
    private List<Reserva> reservas = new ArrayList<>();

    public int getCapacidad() {
        return capacidad;
    }

    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
        this.id_clase = id_clase;
    }
    //Esto lo puse pk sirve y parece el codigo mas poderoso.
    //Comprobacion de si coincide el parametro a introducir con el que se quiere modificar
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Clase clase = (Clase) o;
        return id_clase != null && Objects.equals(id_clase, clase.id_clase);
    }
    //Comprobacion de que los datos que la clase esta contiene bien las variables que
    //se van a meter, devolviendo false si mal y true si bien.
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
