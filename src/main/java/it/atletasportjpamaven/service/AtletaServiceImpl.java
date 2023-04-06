package it.atletasportjpamaven.service;

import java.util.List;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Atleta;

public class AtletaServiceImpl  implements AtletaService{

	@Override
	public void setAtletaDAO(AtletaDAO atletaDAOInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Atleta> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atleta caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Atleta atletaInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Atleta atletaInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rimuovi(Long idAtletaToRemove) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atleta cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSportDAO(SportDAO sportDAOInstance) {
		// TODO Auto-generated method stub
		
	}

}
