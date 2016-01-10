package services.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.AuthentificationServiceLocal;
import entities.SimpleMember;

/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless
public class AuthentificationService implements AuthentificationServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public AuthentificationService() {
		// TODO Auto-generated constructor stub
	}

	public SimpleMember authentifier(String username, String password) {
		SimpleMember utilisateur = null;
		Query query = entityManager
				.createQuery("select u from simpleMember u where u.username=:username and u.password=:password");
		query.setParameter("username", username).setParameter("password",
				password);
		try {
			utilisateur = (SimpleMember) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(
					Level.WARNING,
					"authentication failed with username=" + username
							+ " and password=" + password);
		}
		return utilisateur;
	}

}
