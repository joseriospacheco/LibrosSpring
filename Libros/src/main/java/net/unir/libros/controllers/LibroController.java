package net.unir.libros.controllers;

import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.unir.libros.entities.Libro;
import net.unir.libros.services.LibroService;

@RestController
@RequestMapping("api/v1/libros")
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@PostMapping
	public ResponseEntity<Libro> post(@RequestBody Libro libro) {
		
		
		var nuevoLibro = libroService.registrar(libro);
		
		if(nuevoLibro.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(libro);
		}
		
		
		return ResponseEntity.badRequest().build();
	} 
	
	@GetMapping()
	public ResponseEntity<List<Libro>> get() {
		
		var libros = libroService.consultarLibros();
		
		if(libros.size()>0) {
			
			return ResponseEntity.ok(libros);
		}
		
		return ResponseEntity.notFound().build();
		
		
	} 
	
	@GetMapping(params = "titulo")
	public ResponseEntity<List<Libro>> get(@RequestParam String titulo) {
		
		var libros = libroService.consultarLibros(titulo);
		
		if(libros.size()>0) {
			
			return ResponseEntity.ok(libros);
		}
		
		return ResponseEntity.notFound().build();
		
		
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
