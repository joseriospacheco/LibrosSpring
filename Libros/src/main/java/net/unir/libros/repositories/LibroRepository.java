package net.unir.libros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.unir.libros.entities.Libro;

@Repository
public interface LibroRepository  extends JpaRepository<Libro,Long>{
	
	Libro findByIsbn(String isbn);
	
}
