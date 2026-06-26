package com.fernando6489.taller02.service.impl;

import com.fernando6489.taller02.model.DetallePrestamo;
import com.fernando6489.taller02.repository.DetallePrestamoRepository;
import com.fernando6489.taller02.service.interfaces.DetallePrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePrestamoServiceImpl implements DetallePrestamoService {

    private final DetallePrestamoRepository repository;

    public DetallePrestamoServiceImpl(DetallePrestamoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetallePrestamo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public DetallePrestamo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DetallePrestamo guardar(DetallePrestamo detallePrestamo) {
        return repository.save(detallePrestamo);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}