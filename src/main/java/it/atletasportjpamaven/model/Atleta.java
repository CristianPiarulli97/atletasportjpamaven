package it.atletasportjpamaven.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atleta")
public class Atleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ; 
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "datadinascita")
	private LocalDate dataDiNascita;
	@Column(name = "codice")
	private int codice;
	@Column(name = "numeromedaglievinte")
	private int numeroMedaglieVinte ; 

	@ManyToMany
	@JoinTable(name = "atleta_sport", joinColumns = @JoinColumn(name = "atleta_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "sport_id", referencedColumnName = "ID"))
	private Set <Sport> sports ;

	public Atleta(Long id, String nome, String cognome, LocalDate dataDiNascita, int codice, int numeroMedaglieVinte) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codice = codice;
		this.numeroMedaglieVinte = numeroMedaglieVinte;
	}

	public Atleta(Long id, String nome, String cognome, LocalDate dataDiNascita, int codice, int numeroMedaglieVinte,
			Set<Sport> sports) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codice = codice;
		this.numeroMedaglieVinte = numeroMedaglieVinte;
		this.sports = sports;
	}

	
	
	public Atleta(String nome, String cognome, LocalDate dataDiNascita, int codice, int numeroMedaglieVinte) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codice = codice;
		this.numeroMedaglieVinte = numeroMedaglieVinte;
	}


	public Atleta () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getNumeroMedaglieVinte() {
		return numeroMedaglieVinte;
	}

	public void setNumeroMedaglieVinte(int numeroMedaglieVinte) {
		this.numeroMedaglieVinte = numeroMedaglieVinte;
	}

	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Atleta [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", codice=" + codice + ", numeroMedaglieVinte=" + numeroMedaglieVinte + "]";
	}
	
	
	
	
	
}
