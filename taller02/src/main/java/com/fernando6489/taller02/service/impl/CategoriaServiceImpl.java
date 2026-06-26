package com.fernando6489.taller02.service.impl;

import com.fernando6489.taller02.model.Categoria;
import com.fernando6489.taller02.repository.CategoriaRepository;
import com.fernando6489.taller02.service.interfaces.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}