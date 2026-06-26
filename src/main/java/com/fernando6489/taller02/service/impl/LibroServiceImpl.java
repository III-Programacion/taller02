package com.fernando6489.taller02.service.impl;

import com.fernando6489.taller02.model.Libro;
import com.fernando6489.taller02.repository.LibroRepository;
import com.fernando6489.taller02.service.interfaces.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository repository;

    public LibroServiceImpl(LibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Libro> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Libro buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Libro guardar(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}