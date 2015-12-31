package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.PacksServicesLocal;
import services.interfaces.PacksServicesRemote;
import entities.Packs;

/**
 * Session Bean implementation class PacksServices
 */
@Stateless
public class PacksServices implements PacksServicesRemote, PacksServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PacksServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addPacks(Packs packs) {
		Boolean b = false;
		try {
			entityManager.merge(packs);
			b = true;
		} catch (Exception e) {
			System.err.println("problem adding pack");
		}
		return b;
	}

	@Override
	public Boolean deletePacksById(Integer id) {
		Boolean b = false;
		try {
			Packs packsfound;
			packsfound = entityManager.find(Packs.class, id);
			entityManager.remove(entityManager.merge(packsfound));
			b = true;
		} catch (Exception e) {
			System.err.println("problem deleting packs");
		}
		return b;
	}

	@Override
	public Packs findPacksById(Integer id) {
		Packs packsfound = entityManager.find(Packs.class, id);
		return packsfound;
	}

	@Override
	public Boolean updatePacks(Packs packs) {
		Boolean b = false;
		try {
			entityManager.merge(packs);
			b = true;
		} catch (Exception e) {
			System.err.println("problem updating packs");
		}
		return b;
	}

	@Override
	public Boolean deletePacks(Packs packs) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(packs));
			b = true;
		} catch (Exception e) {
System.err.println("problem deleting packs");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Packs> findAllPacks() {
		String jpql = "select p from Packs p";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
