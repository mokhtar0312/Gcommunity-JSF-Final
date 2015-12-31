package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Equipment;


@Remote
public interface EquipmentServicesRemote {
	
    Boolean addEquipment(Equipment equipment);
	
	Boolean deleteEquipmentById(Integer id);

	Equipment findEquipmentById(Integer id);

	Boolean updateEquipment(Equipment equipment);

	Boolean deleteEquipment(Equipment equipment);

	List<Equipment> findAllEquipment();

}
