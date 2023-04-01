package model;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.*;
@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private LocalDate anno_di_nascita;
	private Long numero_tessera;
	
	public Utente(){
		
	}
	public Utente(String nome, String cognome, LocalDate anno_di_nascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.anno_di_nascita = anno_di_nascita;
		this.numero_tessera= randomGenerator();
	}
	
	
	
	private long randomGenerator() {
		long num = System.currentTimeMillis();
		Random rnum = new Random(num);
		long n = Math.abs(rnum.nextLong()% 90000000l) + 100000000l;
		n *= 10l;
		return n;
	}
	
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", anno_di_nascita=" + anno_di_nascita
				+ ", numero_tessera=" + numero_tessera + "]";
	}
	
	
}
