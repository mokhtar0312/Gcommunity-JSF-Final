package anis;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import anis.interfaces.MessageServiceLocal;
import anis.interfaces.MessageServiceRemote;
import entities.ActiveMember;
import entities.Message;

/**
 * Session Bean implementation class MessageService
 */
@Stateful
@LocalBean
public class MessageService implements MessageServiceRemote,
		MessageServiceLocal {
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public MessageService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean ajouterMessage(Message message) {
		Boolean b = false;
		try {
			entityManager.persist(message);
			b = true;
		} catch (Exception e) {
			System.err.println("l���������");
		}
		return b;
	}

	@Override
	public List<Message> readAllMessage() {
		String jpql = "select m from Message m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean deleteMessageById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Message.class, id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean updateMessage(Message message) {
		Boolean b = false;
		try {
			entityManager.merge(message);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Message findMessageById(Integer id) {
		return entityManager.find(Message.class, id);

	}

	@Override
	public ActiveMember findActiveMemeberByUsername(String username) {
		return entityManager.find(ActiveMember.class, username);

	}

	@Override
	public ActiveMember findActiveMemberById(int i) {
		return entityManager.find(ActiveMember.class, i);

	}

	@Override
	public ActiveMember findActiveMemberByEmail(String email) {
		return entityManager.find(ActiveMember.class, email);

	}

	@Override
	public List<Message> readAllMessageByIDActiveMember(int i) {
		Query query = entityManager
				.createQuery("Select e from Message e where e.idto=:l ");
		query.setParameter("l", i);

		return query.getResultList();
	}

	@Override
	public List<Message> findAllMessage() {
		String jpql = "select m from Message m";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
