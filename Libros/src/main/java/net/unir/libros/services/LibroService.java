package net.unir.libros.services;

import java.util.List;
import java.util.Optional;

import net.unir.libros.entities.Libro;

public interface LibroService {

	Optional<Libro> registrar(Libro libro);
	List<Libro> consultarLibros();
	List<Libro> consultarLibros(String titulo);
	Optional<Libro> consultarLibro(String isbn);
}
