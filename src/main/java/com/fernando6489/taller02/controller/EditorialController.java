package com.fernando6489.taller02.controller;

import com.fernando6489.taller02.model.Editorial;
import com.fernando6489.taller02.service.interfaces.EditorialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/editoriales")
public class EditorialController {

    private final EditorialService service;

    public EditorialController(EditorialService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("editoriales", service.listarTodos());
        return "editoriales/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("editorial", new Editorial());
        return "editoriales/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Editorial editorial) {
        service.guardar(editorial);
        return "redirect:/editoriales";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("editorial", service.buscarPorId(id));
        return "editoriales/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/editoriales";
    }
}