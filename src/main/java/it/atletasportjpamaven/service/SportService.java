package it.atletasportjpamaven.service;

import java.util.List;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Sport;

public interface SportService {

	
	public List<Sport> listAll() throws Exception;

	public Sport caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Sport sportInstance) throws Exception;

	public void inserisciNuovo(Sport sportInstance) throws Exception;

	public void rimuovi(Long idSportToRemove) throws Exception;

	public Sport cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception;
	
	
	void setSportDAO(SportDAO sportDAOInstance);
	void setAtletaDAO(AtletaDAO atletaDAOInstance);
	
	

}
