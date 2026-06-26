package com.fernando6489.taller02.service.interfaces;

import com.fernando6489.taller02.model.Autor;

import java.util.List;

public interface AutorService {

    List<Autor> listarTodos();

    Autor buscarPorId(Long id);

    Autor guardar(Autor autor);

    void eliminar(Long id);

}