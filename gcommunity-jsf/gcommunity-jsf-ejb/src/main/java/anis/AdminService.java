package anis;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import anis.interfaces.AdminServiceLocal;
import anis.interfaces.AdminServiceRemote;
import entities.ActiveMember;
import entities.Message;
import entities.Notification;

/**
 * Session Bean implementation class Admin
 */
@Stateful
@LocalBean
public class AdminService implements AdminServiceRemote, AdminServiceLocal {
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AdminService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interfaceAdministrateur() {
		System.out.println("Ici c'est l'administrateur");

	}

	@Override
	public List<Notification> readAllNotifications() {
		String jpql = "select c from Notification c ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Integer> readAllNotificationsCount() {
		Query query = entityManager
				.createQuery("select count(c) from Notification c where c.stock=:l");

		query.setParameter("l", "New Message");
		return query.getResultList();
	}

	@Override
	public Boolean ajouterMessage(Message message) {
		ActiveMember activeMember = new ActiveMember();
		Notification notification = new Notification();
		notification.setEtat(0);
		notification.setDescription("Nouveau message");
		notification.setMessage(message);
		notification.setActiveMember(activeMember);
		Boolean b = false;
		try {
			entityManager.persist(message);
			entityManager.persist(notification);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public List<Integer> readAllNotificationsCountMessage(
			ActiveMember activeMember) {
		Query query = entityManager
				.createQuery("Select count(e) from Notification e where e.activeMember=:l and e.description=:p");

		query.setParameter("l", activeMember).setParameter("p", "new Message");

		try {
			activeMember = (ActiveMember) query.getSingleResult();

		} catch (Exception e) {
			activeMember = null;
		}

		return query.getResultList();
	}

	@Override
	public List<Integer> readAllNotificationsCountStock(
			ActiveMember activeMember) {
		Query query = entityManager
				.createQuery("Select count(e) from Notification e where e.activeMember=:l and e.description=:p");

		query.setParameter("l", activeMember).setParameter("p", "new Stock");

		try {
			activeMember = (ActiveMember) query.getSingleResult();

		} catch (Exception e) {
			activeMember = null;
		}

		return query.getResultList();
	}

}
