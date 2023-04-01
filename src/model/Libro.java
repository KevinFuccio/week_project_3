package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enum_biblioteca.Book_genre;
@Entity
public class Libro extends Catalogo implements Serializable{

	private String autore;
	@Enumerated(EnumType.STRING)
	private Book_genre genere;
	
	
	
	public Libro() {
		super();
	}

	public Libro(String titolo, Integer anno_pubblicazione, Integer numero_pagine,String autore,Book_genre genere) {
		super(titolo, anno_pubblicazione,numero_pagine);
		this.autore = autore;
		this.genere = genere;
		
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", getTitolo()=" + getTitolo()
				+ ", getAnno_pubblicazione()=" + getAnno_pubblicazione() + ", getNumero_pagine()=" + getNumero_pagine()
				+ "]";
	}
	
	
}
