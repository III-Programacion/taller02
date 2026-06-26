package com.fernando6489.taller02.controller;

import com.fernando6489.taller02.model.Usuario;
import com.fernando6489.taller02.service.interfaces.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("usuarios", usuarioService.listarTodos());

        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult result,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "usuarios/formulario";
        }

        usuarioService.guardar(usuario);

        redirect.addFlashAttribute(
                "success",
                "Usuario guardado correctamente."
        );

        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirect) {

        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario == null) {

            redirect.addFlashAttribute(
                    "error",
                    "El usuario no existe."
            );

            return "redirect:/usuarios";
        }

        model.addAttribute("usuario", usuario);

        return "usuarios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(
            @PathVariable Long id,
            RedirectAttributes redirect) {

        usuarioService.eliminar(id);

        redirect.addFlashAttribute(
                "success",
                "Usuario eliminado correctamente."
        );

        return "redirect:/usuarios";
    }

}