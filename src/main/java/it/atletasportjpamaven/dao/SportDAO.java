package it.atletasportjpamaven.dao;

import java.util.List;

import it.atletasportjpamaven.model.Sport;

public interface SportDAO extends IBaseDAO<Sport>{

	public List<Sport> findMistakes();
	
	public Sport findByDescrizione (String descrizione);
}
