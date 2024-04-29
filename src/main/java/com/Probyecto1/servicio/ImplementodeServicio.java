package com.Probyecto1.servicio;


import com.Probyecto1.Repositorio.Repositoriolibro;
import com.Probyecto1.entidades.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplementodeServicio implements ServicioLibro{

    @Autowired //Inyección de dependencias
    private Repositoriolibro repositoriolibro;

    @Override
    public List<Libro> Encontrarlibros() {
        return repositoriolibro.findAll();
    }

    @Override
    public Optional<Libro> buscarporid(Long idlibro) {
        return repositoriolibro.findById(idlibro);
    }

    @Override
    public Libro guardarlibro(Libro libro) {
        return repositoriolibro.save(libro);
    }

    @Override
    public void updatelibro(Long idlibro, Libro libro) {
        Libro libroBD = buscarporid(idlibro).get();
        libroBD.setTitulo(libro.getTitulo());
        libroBD.setAutor(libro.getAutor());
        libroBD.setGenero(libro.getGenero());
        libroBD.setAño(libro.getAño());
        repositoriolibro.save(libro);

    }

    @Override
    public void deletelibroporid(Long idLibro) {
        repositoriolibro.deleteById(idLibro);


    }
}
