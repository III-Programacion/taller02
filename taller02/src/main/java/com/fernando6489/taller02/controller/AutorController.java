package com.fernando6489.taller02.controller;

import com.fernando6489.taller02.model.Autor;
import com.fernando6489.taller02.service.interfaces.AutorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autores", service.listarTodos());
        return "autores/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("autor") Autor autor,
            BindingResult result,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "autores/formulario";
        }

        service.guardar(autor);

        redirect.addFlashAttribute("success",
                "Autor guardado correctamente.");

        return "redirect:/autores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model,
                         RedirectAttributes redirect) {

        Autor autor = service.buscarPorId(id);

        if (autor == null) {
            redirect.addFlashAttribute("error",
                    "El autor no existe.");
            return "redirect:/autores";
        }

        model.addAttribute("autor", autor);

        return "autores/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,
                           RedirectAttributes redirect) {

        service.eliminar(id);

        redirect.addFlashAttribute("success",
                "Autor eliminado correctamente.");

        return "redirect:/autores";
    }

}