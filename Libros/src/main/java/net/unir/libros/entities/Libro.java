package net.unir.libros.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "libros")
public class Libro {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "isbn", unique=true)
	private String isbn;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "stock")
	private int stock;
	
	
}
