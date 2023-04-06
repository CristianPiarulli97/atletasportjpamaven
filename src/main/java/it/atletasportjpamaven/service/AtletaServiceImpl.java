package it.atletasportjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.EntityManagerUtil;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Atleta;

public class AtletaServiceImpl  implements AtletaService{

	private AtletaDAO atletaDao;
	private SportDAO sportDao;
	
	@Override
	public void setAtletaDAO(AtletaDAO atletaDao) {
		this.atletaDao = atletaDao;
		
	}
	
	public void setSportDAO(SportDAO sportDAO) {
		this.sportDao =sportDAO;
	}

	@Override
	public List<Atleta> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			atletaDao.setEntityManager(entityManager);

			// esecuzione metodo
			return atletaDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Atleta caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			atletaDao.setEntityManager(entityManager);

			// esecuzione metodo
			return atletaDao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Atleta atletaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// è un cambiamento del database,
			// quindi devo iniziare una Transaction
			entityManager.getTransaction().begin();

			// injection
			atletaDao.setEntityManager(entityManager);

			// esecuzione metodo
			atletaDao.update(atletaInstance);

			// faccio il commit
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// faccio rollback se non va a buon fine
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void inserisciNuovo(Atleta atletaInstance) throws Exception {
		
		//Come una connetaction
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// è un cambiamento del database,
			// quindi devo iniziare una Transaction
			entityManager.getTransaction().begin();

			// injection
			atletaDao.setEntityManager(entityManager);

			// esecuzione metodo
			atletaDao.insert(atletaInstance);

			// faccio il commit
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// faccio rollback se non va a buon fine
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}		
	}

	@Override
	public void rimuovi(Long idAtletaToRemove) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// è un cambiamento del database,
			// quindi devo iniziare una Transaction
			entityManager.getTransaction().begin();

			// injection
			atletaDao.setEntityManager(entityManager);

			// esecuzione metodo
			atletaDao.delete(atletaDao.get(idAtletaToRemove));

			// faccio il commit
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// faccio rollback se non va a buon fine
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}		
	}


	

}
