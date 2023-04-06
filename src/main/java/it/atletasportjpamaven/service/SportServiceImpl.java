package it.atletasportjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.EntityManagerUtil;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Sport;

public class SportServiceImpl implements SportService {

	private SportDAO sportDAO;
	private AtletaDAO atletaDAO;
	
	
	@Override
	public void setSportDAO(SportDAO sportDAOInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAtletaDAO(AtletaDAO atletaDAOInstance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sport> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			sportDAO.setEntityManager(entityManager);

			// esecuzione metodo
			return sportDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Sport caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Sport sportInstance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserisciNuovo(Sport sportInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			sportDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			sportDAO.insert(sportInstance);

			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			
			entityManager.getTransaction().rollback();
			
			e.printStackTrace();
			throw e;
			
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void rimuovi(Long idSportToRemove) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sport cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
