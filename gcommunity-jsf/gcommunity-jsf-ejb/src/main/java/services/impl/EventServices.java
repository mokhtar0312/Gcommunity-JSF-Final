package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.EventServicesLocal;
import services.interfaces.EventServicesRemote;
import entities.Event;
import entities.SimpleMember;

/**
 * Session Bean implementation class EventServices
 */
@Stateless
@LocalBean
public class EventServices implements EventServicesRemote, EventServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	ArrayList<Event> List;
	List<SimpleMember> List1;

	/**
	 * Default constructor.
	 */
	public EventServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.persist(event);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteEventById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findEventById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Event findEventById(Integer id) {
		return entityManager.find(Event.class, id);

	}

	@Override
	public Boolean updateEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.merge(event);
			entityManager.flush();
			System.out.println("ouuui");
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(event));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEvents() {
		String jpql = "select e from Event e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Event findEventByName(String nom) {
		System.out.println("found");
		String jpql = "select e from Event e where e.name=:param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", nom);
		return (Event) query.getSingleResult();

	}

	public Boolean affectSimpleMemberToEvent(Event event,
			List<SimpleMember> simpleMembers) {
		Boolean b = false;
		try {

			event.setSimpleMember(simpleMembers);
			entityManager.persist(event);
			System.out.println("weeeeeeeeey");
			event.setNumberOfParticipants(event.getNumberOfParticipants() - 1);
			entityManager.flush();

			b = true;
		} catch (Exception e) {
		}
		System.out.println("noooooooon");
		return b;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEventsRestants(SimpleMember simpleMember) {
		System.out.println(simpleMember.getId());

		//List = (ArrayList <Event>) findAllEvents();
		

	
	
	


		//Query query = entityManager.createQuery("select e from event e  where :emp member of e.SimpleMember"); 
		Query query = entityManager.createQuery("select distinct event from Event event  where :emp not member of event.simpleMember "); 
		query.setParameter("emp", simpleMember);
		return query.getResultList();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Event> FindbyTyped(String typed) {
		String jpql = "SELECT n FROM Event n WHERE n.name LIKE :pattern OR n.description LIKE :pattern1";
		Query query = entityManager.createQuery(jpql);
		String typ = "%" + typed + "%";
		query.setParameter("pattern", typ).setParameter("pattern1", typ);
		return query.getResultList();
	}
}