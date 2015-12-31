package anis;

import java.util.List;

import anis.interfaces.NotificationServiceLocal;
import anis.interfaces.NotificationServiceRemote;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Message;
import entities.Notification;

/**
 * Session Bean implementation class NotificationService
 */
@Stateful
@LocalBean
public class NotificationService implements NotificationServiceRemote, NotificationServiceLocal {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public NotificationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean ajouterNotification(Notification notification) {
		Boolean b = false;
		try {
			entityManager.persist(notification);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public List<Notification> readAllNotifications() {
		Query query = entityManager.createQuery("select c from Notification c where c.description=:l ");
		query.setParameter("l", "new Message");

		return query.getResultList();
	}

	@Override
	public Boolean deleteNotificationById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Notification.class, id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean updateNotification(Notification notification) {
		Boolean b = false;
		try {
			entityManager.merge(notification);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Message getMessageFromNotificationTable(Integer id) {
		Message message;
		Query query = entityManager.createQuery("Select e.message from Notification e where e.idNotif=:l ");
		query.setParameter("l", id);

		try {
			message =  (Message) query.getSingleResult();


		} catch (Exception e) {
		 message=null;
		}
		return (Message) query.getSingleResult();	
	}

	@Override
	public List<Notification> readAllNotificationsStocks() {
		Query query = entityManager.createQuery("select c from Notification c where c.description=:l ");
		query.setParameter("l", "new Stock");

		return query.getResultList();
	}

}
