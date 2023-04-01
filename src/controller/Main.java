package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.postgresql.util.PSQLException;

import enum_biblioteca.Book_genre;
import enum_biblioteca.Magazine_frequency;
import model.Archivio;
import model.Catalogo;
import model.Libro;
import model.Magazine;
import model.Prestito;
import model.Utente;
import utils.JpaUtil;

public class Main {
//	static  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	public static void main(String[] args) {
		Libro libro = new Libro("TOPA",1997,854,"Bebo", Book_genre.Horror);
		Magazine m = new Magazine("GigaChad", 2023, 38, Magazine_frequency.Monthly);
//		Archivio.addArticle(m);
		
		Utente u = new Utente("Rubino","Macis",LocalDate.of(1987, 9, 17));
//		Archivio.addUtente(u);
		
		Prestito p = new Prestito(Archivio.searchCatalogoElementById(10),LocalDate.of(2020, 04, 30),LocalDate.of(2020, 07, 30),Archivio.searchUtenteById(1l));
		
//		Archivio.addPrestito(p);
		
//			Archivio.removeElementById(1);
//		System.out.println(Archivio.searchByDate(1998).size());
//		System.out.println(Archivio.searchByAuthor("Alfredo"));
//		System.out.println(Archivio.searchByTitle("one"));
//		System.out.println(Archivio.elementsLoanedFromUser(1));
		System.out.println(Archivio.expiredLoans());
		
		
	}

}
