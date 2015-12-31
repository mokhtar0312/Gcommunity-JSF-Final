package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.ActiveMemberServicesLocal;
import services.interfaces.ActiveMemberServicesRemote;
import entities.ActiveMember;

/**
 * Session Bean implementation class ActiveMemberServices
 */
@Stateless
@LocalBean
public class ActiveMemberServices implements ActiveMemberServicesRemote,
		ActiveMemberServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ActiveMemberServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addActiveMember(ActiveMember activeMember) {
		Boolean b = false;
		try {
			entityManager.persist(activeMember);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteActiveMemberById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findActiveMemberById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public ActiveMember findActiveMemberById(Integer id) {
		return entityManager.find(ActiveMember.class, id);

	}

	@Override
	public Boolean updateActiveMember(ActiveMember activeMember) {
		Boolean b = false;
		try {
			entityManager.merge(activeMember);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteActiveMember(ActiveMember activeMember) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(activeMember));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiveMember> findAllActiveMember() {
		String jpql = "select m from ActiveMember m";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public ActiveMember findActiveMemberByUserName(String username) {
		ActiveMember found = null;
		
		String jpql = "select m from ActiveMember m where m.username=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param",username);
		try{
			found = (ActiveMember) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
	}

}
