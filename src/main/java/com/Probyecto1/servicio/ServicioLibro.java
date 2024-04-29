package com.Probyecto1.servicio;

import com.Probyecto1.entidades.Libro;

import java.util.List;
import java.util.Optional;

public interface ServicioLibro {

    List<Libro> Encontrarlibros();

    Optional<Libro>  buscarporid(Long idlibro);

    Libro guardarlibro(Libro libro);

    void updatelibro(Long idlibro, Libro libro);

    void deletelibroporid(Long idLibro);

}

//tareas basicas como gusrada,acatualizar y eliminar
