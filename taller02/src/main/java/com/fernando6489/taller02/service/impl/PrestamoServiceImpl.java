package com.fernando6489.taller02.service.impl;

import com.fernando6489.taller02.model.Prestamo;
import com.fernando6489.taller02.repository.PrestamoRepository;
import com.fernando6489.taller02.service.interfaces.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository repository;

    public PrestamoServiceImpl(PrestamoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Prestamo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Prestamo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        return repository.save(prestamo);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}