package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.OneToOne;


@Entity
@NamedQuery(name="Prestito.cercaScaduti", query="SELECT p FROM Prestito p WHERE p.restituzione_effettiva is NULL or p.restituzione_effettiva > p.restituzione_prevista")
public class Prestito implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Catalogo elemento_prestato;
	private LocalDate inizio_prestito;
	private LocalDate restituzione_prevista;
	private LocalDate restituzione_effettiva;
	
	
	
	public Prestito() {
		super();
	}

	public Prestito(Catalogo elemento_prestato, LocalDate inizio_prestito, LocalDate restituzione_effettiva,Utente u) {
		this.elemento_prestato =elemento_prestato;
		this.inizio_prestito = inizio_prestito;
		this.restituzione_prevista = previsione(inizio_prestito);
		this.restituzione_effettiva = restituzione_effettiva;
		this.utente = u;
	}
	
	private LocalDate previsione(LocalDate inizio) {
		LocalDate source = inizio;
		LocalDate endSource = source.plusDays(30);
		return endSource;
	}

	public Utente getUtente() {
		return utente;
	}
	
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	

	public LocalDate getInizio_prestito() {
		return inizio_prestito;
	}

	public void setInizio_prestito(LocalDate inizio_prestito) {
		this.inizio_prestito = inizio_prestito;
	}

	public LocalDate getRestituzione_prevista() {
		return restituzione_prevista;
	}

	public void setRestituzione_prevista(LocalDate restituzione_prevista) {
		this.restituzione_prevista = restituzione_prevista;
	}

	public LocalDate getRestituzione_effettiva() {
		return restituzione_effettiva;
	}

	public void setRestituzione_effettiva(LocalDate restituzione_effettiva) {
		this.restituzione_effettiva = restituzione_effettiva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", elemento_prestato=" + elemento_prestato
				+ ", inizio_prestito=" + inizio_prestito + ", restituzione_prevista=" + restituzione_prevista
				+ ", restituzione_effettiva=" + restituzione_effettiva + "]";
	}

	

	
	
	
}
