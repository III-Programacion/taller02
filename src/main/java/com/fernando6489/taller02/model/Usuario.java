package com.fernando6489.taller02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La cédula es obligatoria")
    @Column(nullable = false, unique = true, length = 10)
    private String cedula;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo inválido")
    @Column(nullable = false, unique = true)
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(nullable = false, length = 15)
    private String telefono;

    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Prestamo> prestamos = new ArrayList<>();

}