package it.atletasportjpamaven.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import it.atletasportjpamaven.model.Atleta;
import it.atletasportjpamaven.model.Sport;

public class AtletaDAOImpl implements AtletaDAO {

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


}
