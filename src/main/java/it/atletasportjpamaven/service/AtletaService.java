package it.atletasportjpamaven.service;

import java.util.List;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Atleta;

public interface AtletaService {
	
	
	public List<Atleta> listAll() throws Exception;

	public Atleta caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Atleta atletaInstance) throws Exception;

	public void inserisciNuovo(Atleta atletaInstance) throws Exception;

	public void rimuovi(Long idAtletaToRemove) throws Exception;

	
	

	
	
	void setAtletaDAO(AtletaDAO atletaDAOInstance);
	void setSportDAO(SportDAO sportDAOInstance);

	
}
