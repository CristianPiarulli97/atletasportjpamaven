package it.atletasportjpamaven.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

public class AtletaDAOImpl implements AtletaDAO {

	private AtletaDAO atletaDAO;
	private SportDAO sportDAO;
	
	
	private EntityManager entityManager;

	@Override
	public List<Atleta> list() throws Exception {
		return entityManager.createQuery("from Atleta", Atleta.class).getResultList();
	}

	@Override
	public Atleta get(Long id) throws Exception {
		return entityManager.find(Atleta.class, id);
	}

	@Override
	public void update(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null)
			throw new Exception("Problema valore input");
		atletaInstance = entityManager.merge(atletaInstance);		
	}

	@Override
	public void insert(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null)
			throw new Exception("Problema valore input");
		entityManager.persist(atletaInstance);		
	}

	@Override
	public void delete(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null)
			throw new Exception("Problema valore input");
		entityManager.remove(entityManager.merge(atletaInstance));		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	public Long sumMedaglieVinteSportChiusi() {
		Long somma = 0l;
		javax.persistence.Query query = entityManager.createQuery("select sum(a.numeroMedaglieVinte) from Atleta a join a.sports s where s.dataFine is not null");
		somma = (Long) query.getSingleResult();
		return somma;
	}

	public List<Atleta> findByDescrizioneSport(String descrizione) {
		
		TypedQuery<Atleta> query = entityManager.createQuery("select a from Atleta a left join fetch a.sports s where s.descrizione = :descrizione", Atleta.class);
		query.setParameter("descrizione", descrizione);
		return query.getResultList();
	}

	public void rimuoviSport(Atleta atletaEsistente, Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {

			// è un cambiamento del database,
			// quindi devo iniziare una Transaction
			entityManager.getTransaction().begin();

			// injection
			atletaDAO.setEntityManager(entityManager);

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
