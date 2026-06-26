package com.fernando6489.taller02.service.impl;

import com.fernando6489.taller02.model.Autor;
import com.fernando6489.taller02.repository.AutorRepository;
import com.fernando6489.taller02.service.interfaces.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository repository;

    public AutorServiceImpl(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Autor> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Autor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Autor guardar(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}