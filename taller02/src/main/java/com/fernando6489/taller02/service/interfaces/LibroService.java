package com.fernando6489.taller02.service.interfaces;

import com.fernando6489.taller02.model.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> listarTodos();

    Libro buscarPorId(Long id);

    Libro guardar(Libro libro);

    void eliminar(Long id);

}