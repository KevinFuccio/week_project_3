package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Catalogo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer isbn;
	private String titolo;
	private Integer anno_pubblicazione;
	private Integer numero_pagine;
	
	public Catalogo() {
		
	}
	public Catalogo(String titolo, Integer anno_pubblicazione, Integer numero_pagine) {
		this.titolo = titolo;
		this.anno_pubblicazione = anno_pubblicazione;
		this.numero_pagine = numero_pagine;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public Integer getAnno_pubblicazione() {
		return anno_pubblicazione;
	}


	public void setAnno_pubblicazione(Integer anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}


	public Integer getNumero_pagine() {
		return numero_pagine;
	}


	public void setNumero_pagine(Integer numero_pagine) {
		this.numero_pagine = numero_pagine;
	}


	public Integer getIsbn() {
		return isbn;
	}
	
	
	
}
