package com.fernando6489.taller02.service.interfaces;

import com.fernando6489.taller02.model.Prestamo;

import java.util.List;

public interface PrestamoService {

    List<Prestamo> listarTodos();

    Prestamo buscarPorId(Long id);

    Prestamo guardar(Prestamo prestamo);

    void eliminar(Long id);

}