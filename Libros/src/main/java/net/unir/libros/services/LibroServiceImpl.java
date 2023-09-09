package net.unir.libros.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.unir.libros.entities.Libro;
import net.unir.libros.repositories.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Override
	public List<Libro> consultarLibros() {

		return libroRepository.findAll();
	}

	@Override
	public Optional<Libro> consultarLibro(String isbn) {

		var libroEncontrado = libroRepository.findByIsbn(isbn);

		if (!Objects.isNull(libroEncontrado)) {

			return Optional.of(libroEncontrado);
		}

		return Optional.empty();
	}

	@Override
	public Optional<Libro> registrar(Libro libro) {
		// TODO Auto-generated method stub

		var libroEncontrado = consultarLibro(libro.getIsbn());

		if (libroEncontrado.isPresent()) {

			return Optional.empty();
			
		} else {

			return Optional.of(libroRepository.save(libro));

		}
	}

	@Override
	public List<Libro> consultarLibros(String titulo) {
	
		return	libroRepository.findByTituloContains(titulo);

	}
}
