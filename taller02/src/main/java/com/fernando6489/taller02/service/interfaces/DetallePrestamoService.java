package com.fernando6489.taller02.service.interfaces;

import com.fernando6489.taller02.model.DetallePrestamo;

import java.util.List;

public interface DetallePrestamoService {

    List<DetallePrestamo> listarTodos();

    DetallePrestamo buscarPorId(Long id);

    DetallePrestamo guardar(DetallePrestamo detallePrestamo);

    void eliminar(Long id);

}