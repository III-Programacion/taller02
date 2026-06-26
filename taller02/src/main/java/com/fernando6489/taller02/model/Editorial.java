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
@Table(name = "editoriales")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la editorial es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La ciudad es obligatoria")
    @Column(nullable = false, length = 80)
    private String ciudad;

    @OneToMany(mappedBy = "editorial",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();

}