package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import enum_biblioteca.Magazine_frequency;

@Entity
public class Magazine extends Catalogo implements Serializable{
	@Enumerated(EnumType.STRING)
	private Magazine_frequency periodicita;

	public Magazine() {
		super();
	}
	
	public Magazine(String titolo, Integer anno_pubblicazione, Integer numero_pagine, Magazine_frequency periodicita) {
		super(titolo, anno_pubblicazione, numero_pagine);
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Magazine [periodicita=" + periodicita + ", getTitolo()=" + getTitolo() + ", getAnno_pubblicazione()="
				+ getAnno_pubblicazione() + ", getNumero_pagine()=" + getNumero_pagine() + ", getIsbn()=" + getIsbn()
				+ "]";
	}

	
}
