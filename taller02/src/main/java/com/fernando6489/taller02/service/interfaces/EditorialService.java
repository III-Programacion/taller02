package com.fernando6489.taller02.service.interfaces;

import com.fernando6489.taller02.model.Editorial;

import java.util.List;

public interface EditorialService {

    List<Editorial> listarTodos();

    Editorial buscarPorId(Long id);

    Editorial guardar(Editorial editorial);

    void eliminar(Long id);

}