package com.fernando6489.taller02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del autor es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La nacionalidad es obligatoria")
    @Column(nullable = false, length = 50)
    private String nacionalidad;

    @OneToMany(mappedBy = "autor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();

}