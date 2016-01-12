package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import services.interfaces.EquipmentServicesRemote;
import entities.Equipment;

@ManagedBean(name = "equipments")
@RequestScoped
public class EquipmentBean {

	@EJB
	private EquipmentServicesRemote servicesRemote;

	private List<Equipment> equipments;
	private Equipment p = new Equipment();
	private boolean showForm = false;
	private Boolean dispTable = false;
	private String name;
	private int id;
	private boolean edit;
	private String searchh;

	public EquipmentBean() {
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Equipment getP() {
		return p;
	}

	public void setP(Equipment p) {
		this.p = p;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public Boolean getDispTable() {
		return dispTable;
	}

	public void setDispTable(Boolean dispTable) {
		this.dispTable = dispTable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getSearchh() {
		return searchh;
	}

	public void setSearchh(String searchh) {
		this.searchh = searchh;
	}

	@PostConstruct
	private void init() {
		setEquipments(servicesRemote.findAllEquipment());
	}

	public void doDisplayTable() {
		dispTable = true;
	}

	public String doCreateEquipment() {

		servicesRemote.addEquipment(p);
		init();
		p = new Equipment();
		dispTable = false;

		return "";
	}

	public void edit(Equipment item) {

		this.p = item;
		edit = true;
	}

	public String doDeleteEquipment() {
		servicesRemote.deleteEquipment(p);
		init();
		p = new Equipment();
		return "";
	}

	public String doFindPaksByName() {
		equipments = (List<Equipment>) servicesRemote
				.findEquipmentByName(searchh);
		return "";
	}

	public String doUpdateEquipment() {
		servicesRemote.updateEquipment(p);
		init();
		p = new Equipment();
		return "";
	}

	public String doFindEquipmentById(int id) {
		servicesRemote.findEquipmentById(id);
		return "";
	}

}
