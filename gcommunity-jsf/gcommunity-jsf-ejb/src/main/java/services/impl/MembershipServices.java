package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.MembershipServicesLocal;
import services.interfaces.MembershipServicesRemote;
import entities.Membership;

/**
 * Session Bean implementation class MembershipServices
 */
@Stateless
@LocalBean
public class MembershipServices implements MembershipServicesRemote,
		MembershipServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public MembershipServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEvent(Membership membership) {
		Boolean b = false;
		try {
			entityManager.persist(membership);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteMemberShipById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findMemberShipById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Membership findMemberShipById(Integer id) {
		return entityManager.find(Membership.class, id);

	}

	@Override
	public Boolean updateMemberShip(Membership membership) {
		Boolean b = false;
		try {
			entityManager.merge(membership);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;

	}

	@Override
	public Boolean deleteMemberShip(Membership membership) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(membership));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Membership> findAllMemberShips() {
		String jpql = "select m from MemberShip m";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
