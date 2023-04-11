package it.atletasportjpamaven.dao;

import java.util.List;

import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

public interface AtletaDAO extends IBaseDAO<Atleta> {
	
	public Long sumMedaglieVinteSportChiusi();

	public List<Atleta> findByDescrizioneSport(String descrizione);

	public void rimuoviSport(Atleta atletaEsistente, Sport sportInstance) throws Exception ;

}
