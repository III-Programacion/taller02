package com.fernando6489.taller02.controller;

import com.fernando6489.taller02.model.Prestamo;
import com.fernando6489.taller02.service.interfaces.PrestamoService;
import com.fernando6489.taller02.service.interfaces.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final UsuarioService usuarioService;

    public PrestamoController(
            PrestamoService prestamoService,
            UsuarioService usuarioService) {

        this.prestamoService = prestamoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("prestamos",
                prestamoService.listarTodos());

        return "prestamos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        Prestamo prestamo = new Prestamo();

        model.addAttribute("prestamo", prestamo);

        model.addAttribute("usuarios",
                usuarioService.listarTodos());

        return "prestamos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("prestamo") Prestamo prestamo,
            BindingResult result,
            Model model,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {

            model.addAttribute("usuarios",
                    usuarioService.listarTodos());

            return "prestamos/formulario";
        }

        prestamoService.guardar(prestamo);

        redirect.addFlashAttribute(
                "success",
                "Préstamo registrado correctamente."
        );

        return "redirect:/prestamos";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirect) {

        Prestamo prestamo = prestamoService.buscarPorId(id);

        if (prestamo == null) {

            redirect.addFlashAttribute(
                    "error",
                    "El préstamo no existe."
            );

            return "redirect:/prestamos";
        }

        model.addAttribute("prestamo", prestamo);

        model.addAttribute("usuarios",
                usuarioService.listarTodos());

        return "prestamos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(
            @PathVariable Long id,
            RedirectAttributes redirect) {

        prestamoService.eliminar(id);

        redirect.addFlashAttribute(
                "success",
                "Préstamo eliminado correctamente."
        );

        return "redirect:/prestamos";
    }

}