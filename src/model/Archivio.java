package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.postgresql.util.PSQLException;

import utils.JpaUtil;



public class Archivio {
	static  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	static public void addArticle(Catalogo e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
;
		}
	static public void addUtente(Utente e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
;
		}
	static public void addPrestito(Prestito e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
;
		}
	
	static public  Catalogo searchCatalogoElementById(int id) {
		em.getTransaction().begin();
		Catalogo c = em.find(Catalogo.class, id);
		em.getTransaction().commit();
		return c;
	}
	static public void removeElementById(int id){
		em.getTransaction().begin();
		Catalogo c = em.find(Catalogo.class, id);
		em.remove(c);
		em.getTransaction().commit();
		
	}
	static public  Utente searchUtenteById(Long id) {
		em.getTransaction().begin();
		Utente u = em.find(Utente.class, id);
		em.getTransaction().commit();
		return u;
	}
	static public void searchISBN(int id) {
		em.getTransaction().begin();
		Catalogo c = em.find(Catalogo.class, id);
		System.out.println(c.toString());
	}
	static public List<Catalogo> searchByDate(int anno) {
		Query q = em.createQuery("SELECT el FROM Catalogo el WHERE el.anno_pubblicazione = :anno");
		q.setParameter("anno",anno);
		return q.getResultList();
	}
	static public List<Catalogo> searchByAuthor(String autore) {
		Query q = em.createQuery("SELECT el FROM Catalogo el WHERE el.autore = :autore");
		q.setParameter("autore",autore);
		return q.getResultList();
	}
	static public List<Catalogo> searchByTitle(String title) {
		Query q = em.createQuery("SELECT el  FROM Catalogo el WHERE LOWER (el.titolo) LIKE LOWER ('%' || :titolo || '%') ");
		q.setParameter("titolo",title);
		return q.getResultList();
	}
	static public List<Catalogo> elementsLoanedFromUser(Long id){
		Query q = em.createQuery("SELECT el FROM Prestito el WHERE el.utente.numero_tessera = :id and el.restituzione_effettiva =null");
		q.setParameter("id",id);
		return q.getResultList();
	}
	static public List<Catalogo> expiredLoans(){
		Query q = em.createNamedQuery("Prestito.cercaScaduti");
		return q.getResultList();
	}
}

