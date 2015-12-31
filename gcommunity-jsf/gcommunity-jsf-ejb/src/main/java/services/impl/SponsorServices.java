package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.SponsorServicesLocal;
import services.interfaces.SponsorServicesRemote;
import entities.Sponsor;

/**
 * Session Bean implementation class SponsorServices
 */
@Stateless
@LocalBean
public class SponsorServices implements SponsorServicesRemote,
		SponsorServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SponsorServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addSponsor(Sponsor sponsor) {
		Boolean b = false;
		try {
			entityManager.persist(sponsor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteSponsorById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findSponsorById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Sponsor findSponsorById(Integer id) {
		return entityManager.find(Sponsor.class, id);

	}

	@Override
	public Boolean updateSponsor(Sponsor sponsor) {
		Boolean b = false;
		try {
			entityManager.merge(sponsor);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteSponsor(Sponsor sponsor) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(sponsor));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sponsor> findAllSponsors() {
		String jpql = "select s from Sponsor s";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
