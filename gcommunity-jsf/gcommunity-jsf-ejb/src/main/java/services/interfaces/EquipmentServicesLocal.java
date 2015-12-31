package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Equipment;

@Local
public interface EquipmentServicesLocal {
Boolean addEquipment(Equipment equipment);
	
	Boolean deleteEquipmentById(Integer id);

	Equipment findEquipmentById(Integer id);

	Boolean updateEquipment(Equipment equipment);

	Boolean deleteEquipment(Equipment equipment);

	List<Equipment> findAllEquipment();

}
