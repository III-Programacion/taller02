package com.fernando6489.taller02.service.impl;

import com.fernando6489.taller02.model.Editorial;
import com.fernando6489.taller02.repository.EditorialRepository;
import com.fernando6489.taller02.service.interfaces.EditorialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialServiceImpl implements EditorialService {

    private final EditorialRepository repository;

    public EditorialServiceImpl(EditorialRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Editorial> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Editorial buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Editorial guardar(Editorial editorial) {
        return repository.save(editorial);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}