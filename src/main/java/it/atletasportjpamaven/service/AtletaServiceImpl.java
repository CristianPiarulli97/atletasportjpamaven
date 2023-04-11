package it.atletasportjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.atletasportjpamaven.dao.AtletaDAO;
import it.atletasportjpamaven.dao.EntityManagerUtil;
import it.atletasportjpamaven.dao.SportDAO;
import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

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

	public Long sommaMedaglieVinteInSportChiusi() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			atletaDao.setEntityManager(entityManager);

			// esecuzione metodo
			return atletaDao.sumMedaglieVinteSportChiusi();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
	
	public List<Atleta> listaAtletiAppartenentiAUnoSport(String descrizione) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			// injection
			atletaDao.setEntityManager(entityManager);

			// esecuzione metodo
			return atletaDao.findByDescrizioneSport(descrizione);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
	
	
	
	public void aggiungiSport(Atleta atletaEsistente, Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// è un cambiamento del database,
			// quindi devo iniziare una Transaction
			entityManager.getTransaction().begin();

			// injection
			atletaDao.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate i due oggetti
			// così jpa capisce che se è già presente quel ruolo non deve essere inserito

			atletaEsistente = entityManager.merge(atletaEsistente);
			sportInstance = entityManager.merge(sportInstance);

			atletaEsistente.getSports().add(sportInstance);
			// l'update non viene richiamato a mano in quanto
			// risulta automatico, infatti il contesto di persistenza
			// rileva che atletaEsistente ora è dirty vale a dire che una sua
			// proprieta ha subito una modifica (vale anche per i Set ovviamente)

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

	public void rimuoviSport(Atleta atletaEsistente, Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// è un cambiamento del database,
			// quindi devo iniziare una Transaction
			entityManager.getTransaction().begin();

			// injection
			atletaDao.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate i due oggetti
			// così jpa capisce che se è già presente quel ruolo non deve essere inserito

			atletaEsistente = entityManager.merge(atletaEsistente);
			sportInstance = entityManager.merge(sportInstance);

			atletaEsistente.getSports().remove(sportInstance);
			// l'update non viene richiamato a mano in quanto
			// risulta automatico, infatti il contesto di persistenza
			// rileva che atletaEsistente ora è dirty vale a dire che una sua
			// proprieta ha subito una modifica (vale anche per i Set ovviamente)

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
