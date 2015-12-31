package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.EquipmentServicesLocal;
import services.interfaces.EquipmentServicesRemote;
import entities.Equipment;

/**
 * Session Bean implementation class EquipmentServices
 */
@Stateless
@LocalBean
public class EquipmentServices implements EquipmentServicesRemote,
		EquipmentServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EquipmentServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEquipment(Equipment equipment) {
		Boolean b = false;
		try {
			entityManager.persist(equipment);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteEquipmentById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findEquipmentById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Equipment findEquipmentById(Integer id) {
		return entityManager.find(Equipment.class, id);
	}

	@Override
	public Boolean updateEquipment(Equipment equipment) {
		Boolean b = false;
		try {
			entityManager.merge(equipment);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteEquipment(Equipment equipment) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(equipment));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public List<Equipment> findAllEquipment() {
		String jpql = "select e from Equipment e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
