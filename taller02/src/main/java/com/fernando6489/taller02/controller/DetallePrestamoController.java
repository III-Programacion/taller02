package com.fernando6489.taller02.controller;

import com.fernando6489.taller02.model.DetallePrestamo;
import com.fernando6489.taller02.service.interfaces.DetallePrestamoService;
import com.fernando6489.taller02.service.interfaces.LibroService;
import com.fernando6489.taller02.service.interfaces.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/detalleprestamos")
public class DetallePrestamoController {

    private final DetallePrestamoService detallePrestamoService;
    private final PrestamoService prestamoService;
    private final LibroService libroService;

    public DetallePrestamoController(
            DetallePrestamoService detallePrestamoService,
            PrestamoService prestamoService,
            LibroService libroService) {

        this.detallePrestamoService = detallePrestamoService;
        this.prestamoService = prestamoService;
        this.libroService = libroService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("detalles",
                detallePrestamoService.listarTodos());

        return "detalleprestamos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("detallePrestamo", new DetallePrestamo());

        model.addAttribute("prestamos",
                prestamoService.listarTodos());

        model.addAttribute("libros",
                libroService.listarTodos());

        return "detalleprestamos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("detallePrestamo")
            DetallePrestamo detallePrestamo,
            BindingResult result,
            Model model,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {

            model.addAttribute("prestamos",
                    prestamoService.listarTodos());

            model.addAttribute("libros",
                    libroService.listarTodos());

            return "detalleprestamos/formulario";
        }

        detallePrestamoService.guardar(detallePrestamo);

        redirect.addFlashAttribute(
                "success",
                "Detalle del préstamo registrado correctamente."
        );

        return "redirect:/detalleprestamos";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model,
            RedirectAttributes redirect) {

        DetallePrestamo detalle =
                detallePrestamoService.buscarPorId(id);

        if (detalle == null) {

            redirect.addFlashAttribute(
                    "error",
                    "El detalle del préstamo no existe."
            );

            return "redirect:/detalleprestamos";
        }

        model.addAttribute("detallePrestamo", detalle);

        model.addAttribute("prestamos",
                prestamoService.listarTodos());

        model.addAttribute("libros",
                libroService.listarTodos());

        return "detalleprestamos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(
            @PathVariable Long id,
            RedirectAttributes redirect) {

        detallePrestamoService.eliminar(id);

        redirect.addFlashAttribute(
                "success",
                "Detalle eliminado correctamente."
        );

        return "redirect:/detalleprestamos";
    }

}