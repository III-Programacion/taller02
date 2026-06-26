package com.fernando6489.taller02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle_prestamos")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DetallePrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mayor que cero")
    @Column(nullable = false)
    private Integer cantidad;

}