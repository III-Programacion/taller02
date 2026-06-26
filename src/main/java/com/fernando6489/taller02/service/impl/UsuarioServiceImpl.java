package com.fernando6489.taller02.service.impl;

import com.fernando6489.taller02.model.Usuario;
import com.fernando6489.taller02.repository.UsuarioRepository;
import com.fernando6489.taller02.service.interfaces.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}