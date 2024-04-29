package com.Probyecto1.controller;


import com.Probyecto1.entidades.Libro;
import com.Probyecto1.servicio.ImplementodeServicio;
import com.Probyecto1.servicio.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Librocontroller {

    @Autowired
    private ServicioLibro servicioLibro;

    @GetMapping("/")
    public  String listarTodosLoslibros(Model model){
        model.addAttribute("libros",servicioLibro.Encontrarlibros());
        return "/listalibros";
    }

    @GetMapping("/NuevoLibro")
    public  String registrarNuevoLibro(){
        return "/RegistroLibros";
    }

    @PostMapping("/guardarLibro")
    public  String guardarLibro(Libro libro){
        servicioLibro.guardarlibro(libro);
        return "redirect:/";
    }

    @GetMapping("/editarLibro/{id}")
    public  String editarLibro(@PathVariable Long id, Model model){
        Libro libro = servicioLibro.buscarporid(id).get();
        model.addAttribute("libro",libro);
                return "/EditarLibro";
    }

    @PostMapping("/actualizarLibro")
    public  String actualizarLibro(@RequestParam("idLibro") Long id, Libro libro){
        servicioLibro.updatelibro(id,libro);
        return  "redirect:/";
    }

}
