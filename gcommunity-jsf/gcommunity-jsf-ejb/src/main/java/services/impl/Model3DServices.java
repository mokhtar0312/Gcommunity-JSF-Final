package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.Model3DServicesLocal;
import services.interfaces.Model3DServicesRemote;
import entities.Model3D;

/**
 * Session Bean implementation class Model3D
 */
@Stateless
@LocalBean
public class Model3DServices implements Model3DServicesRemote, Model3DServicesLocal {
	@PersistenceContext
	EntityManager entitymanager;

	/**
	 * Default constructor.
	 */

	@Override
	public Boolean addM(Model3D model3d) {
		boolean b = false;
		try {
			entitymanager.persist(model3d);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Model3D findModel3DById(Integer id) {

		return entitymanager.find(Model3D.class, id);
	}

	@Override
	public Boolean updateModel3D(Model3D model3d) {
		boolean b = false;
		try {
			entitymanager.merge(model3d);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteModel3D(Integer id) {
		boolean b=false;
		try {
		entitymanager.remove(findModel3DById(id));	
		b=true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return null;
	}

	@Override
	public List<Model3D> finAll3DModels() {
		
		String jpql = "select m from Model3D m";
		Query query = entitymanager.createQuery(jpql);
		
		return query.getResultList();
	}

}
