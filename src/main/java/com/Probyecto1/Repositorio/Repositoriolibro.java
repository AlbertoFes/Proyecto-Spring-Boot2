package com.Probyecto1.Repositorio;


import com.Probyecto1.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Repositoriolibro extends JpaRepository<Libro,Long> {
}
