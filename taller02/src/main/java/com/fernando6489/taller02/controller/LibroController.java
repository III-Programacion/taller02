package com.fernando6489.taller02.controller;

import com.fernando6489.taller02.model.Libro;
import com.fernando6489.taller02.service.interfaces.AutorService;
import com.fernando6489.taller02.service.interfaces.CategoriaService;
import com.fernando6489.taller02.service.interfaces.EditorialService;
import com.fernando6489.taller02.service.interfaces.LibroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final LibroService libroService;
    private final AutorService autorService;
    private final CategoriaService categoriaService;
    private final EditorialService editorialService;

    public LibroController(
            LibroService libroService,
            AutorService autorService,
            CategoriaService categoriaService,
            EditorialService editorialService) {

        this.libroService = libroService;
        this.autorService = autorService;
        this.categoriaService = categoriaService;
        this.editorialService = editorialService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("libros", libroService.listarTodos());

        return "libros/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("libro", new Libro());

        model.addAttribute("autores",
                autorService.listarTodos());

        model.addAttribute("categorias",
                categoriaService.listarTodos());

        model.addAttribute("editoriales",
                editorialService.listarTodos());

        return "libros/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("libro") Libro libro,
            BindingResult result,
            Model model,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {

            model.addAttribute("autores",
                    autorService.listarTodos());

            model.addAttribute("categorias",
                    categoriaService.listarTodos());

            model.addAttribute("editoriales",
                    editorialService.listarTodos());

            return "libros/formulario";
        }

        libroService.guardar(libro);

        redirect.addFlashAttribute("success",
                "Libro guardado correctamente.");

        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirect) {

        Libro libro = libroService.buscarPorId(id);

        if (libro == null) {

            redirect.addFlashAttribute("error",
                    "El libro no existe.");

            return "redirect:/libros";
        }

        model.addAttribute("libro", libro);

        model.addAttribute("autores",
                autorService.listarTodos());

        model.addAttribute("categorias",
                categoriaService.listarTodos());

        model.addAttribute("editoriales",
                editorialService.listarTodos());

        return "libros/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(
            @PathVariable Long id,
            RedirectAttributes redirect) {

        libroService.eliminar(id);

        redirect.addFlashAttribute("success",
                "Libro eliminado correctamente.");

        return "redirect:/libros";
    }

}