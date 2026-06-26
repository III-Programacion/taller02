package com.fernando6489.taller02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libros")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Column(nullable = false, length = 150)
    private String titulo;

    @NotBlank(message = "El ISBN es obligatorio")
    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @NotNull(message = "El año de publicación es obligatorio")
    private Integer anioPublicacion;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "editorial_id", nullable = false)
    private Editorial editorial;

    @OneToMany(mappedBy = "libro",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<DetallePrestamo> detalles = new ArrayList<>();

}