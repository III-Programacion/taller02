package com.fernando6489.taller02.service.interfaces;

import com.fernando6489.taller02.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listarTodos();

    Categoria buscarPorId(Long id);

    Categoria guardar(Categoria categoria);

    void eliminar(Long id);

}