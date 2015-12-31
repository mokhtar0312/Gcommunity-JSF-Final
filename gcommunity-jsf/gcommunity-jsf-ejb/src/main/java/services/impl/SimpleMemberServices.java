package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.SimpleMemberServicesLocal;
import services.interfaces.SimpleMemberServicesRemote;
import entities.Event;
import entities.SimpleMember;

/**
 * Session Bean implementation class SimpleMemberServices
 */
@Stateless
@LocalBean
public class SimpleMemberServices implements SimpleMemberServicesRemote, SimpleMemberServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public SimpleMemberServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addSimpleMember(SimpleMember simpleMember) {
		Boolean b = false;
		try {
			entityManager.persist(simpleMember);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteSimpleMemberById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findSimpleMemberById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public SimpleMember findSimpleMemberById(Integer id) {
		return entityManager.find(SimpleMember.class, id);

	}

	@Override
	public Boolean updateSimpleMember(SimpleMember simpleMember) {
		Boolean b = false;
		try {
			entityManager.merge(simpleMember);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteSimpleMember(SimpleMember simpleMember) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(simpleMember));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SimpleMember> findAllSimpleMember() {
		String jpql = "select m from ActiveMember m";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean affectEventToSimpleMember(SimpleMember simpleMember,
			Event event) {
		Boolean b = false;
		try {

			List<Event> events = simpleMember.getEvents();
			events.add(event);
			
			simpleMember.setEvents(events);
			updateSimpleMember(simpleMember);

			b = true;
		} catch (Exception e) {
		}
		System.out.println("noooooooon");
		return b;
	}	}


