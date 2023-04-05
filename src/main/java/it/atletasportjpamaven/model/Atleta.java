package it.atletasportjpamaven.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "atleta")
public class Atleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	@Column(name = "id")
	private String nome;
	@Column(name = "id")
	private String cognome;
	@Column(name = "id")
	private LocalDate dataDiNascita;
	@Column(name = "id")
	private int codice;
	@Column(name = "id")
	private int numeroMedaglieVinte ; 
	
	Sport sports;
	
}
