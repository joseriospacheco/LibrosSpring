package net.unir.libros.controllers;

import java.util.List;
import java.util.Objects;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.unir.libros.entities.Libro;
import net.unir.libros.services.LibroService;

@RestController
@RequestMapping("api/v1/libros")
public class LibrosController {

	@Autowired
	private LibroService libroService;
	
	@PostMapping
	public ResponseEntity<Libro> post(@RequestBody Libro libro) {
		
		
		var nuevoLibro = libroService.registrar(libro);
		
		if(nuevoLibro.isPresent()) {
			
			return ResponseEntity.ok(nuevoLibro.get());
		}
		
		
		return ResponseEntity.unprocessableEntity().build();
	} 
	
	@GetMapping()
	public ResponseEntity<List<Libro>> get() {
		
		return ResponseEntity.ok(libroService.consultarLibros());
	} 
	
	@GetMapping("{isbn}")
	public ResponseEntity<Libro> gets(@PathVariable String isbn) {
		
		var libro = libroService.consultarLibro(isbn);
		
		if(libro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(libro.get());
	} 
}
