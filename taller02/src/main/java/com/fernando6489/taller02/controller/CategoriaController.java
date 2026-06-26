package com.fernando6489.taller02.controller;

import com.fernando6489.taller02.model.Categoria;
import com.fernando6489.taller02.service.interfaces.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", service.listarTodos());
        return "categorias/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("categoria") Categoria categoria,
            BindingResult result,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "categorias/formulario";
        }

        service.guardar(categoria);

        redirect.addFlashAttribute("success",
                "Categoría guardada correctamente.");

        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model,
                         RedirectAttributes redirect) {

        Categoria categoria = service.buscarPorId(id);

        if (categoria == null) {
            redirect.addFlashAttribute("error",
                    "La categoría no existe.");
            return "redirect:/categorias";
        }

        model.addAttribute("categoria", categoria);

        return "categorias/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,
                           RedirectAttributes redirect) {

        service.eliminar(id);

        redirect.addFlashAttribute("success",
                "Categoría eliminada correctamente.");

        return "redirect:/categorias";
    }

}