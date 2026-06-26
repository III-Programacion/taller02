package com.fernando6489.taller02.service.interfaces;

import com.fernando6489.taller02.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarTodos();

    Usuario buscarPorId(Long id);

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);

}