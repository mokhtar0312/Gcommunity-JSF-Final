package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import services.interfaces.PacksServicesRemote;
import entities.Packs;

@ManagedBean(name = "packs")
@RequestScoped
public class PacksBean {

	@EJB
	private PacksServicesRemote servicesRemote;

	private List<Packs> packss;
	private Packs p = new Packs();
	private boolean showForm = false;
	private Boolean dispTable = false;
	private String name;
	private int id;
	private boolean edit;
	private String searchh;

	public PacksBean() {
	}

	public List<Packs> getPackss() {
		return packss;
	}

	public void setPackss(List<Packs> packss) {
		this.packss = packss;
	}

	public Packs getP() {
		return p;
	}

	public void setP(Packs p) {
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
		setPackss(servicesRemote.findAllPacks());
	}

	public void doDisplayTable() {
		dispTable = true;
	}

	public String doCreatePacks() {

		servicesRemote.addPacks(p);
		init();
		p = new Packs();
		dispTable = false;

		return "";
	}

	public void edit(Packs item) {

		this.p = item;
		edit = true;
	}

	public String doDeletePacks() {
		servicesRemote.deletePacks(p);
		init();
		p = new Packs();
		return "";
	}

	public String doFindPaksByName() {
		packss = (List<Packs>) servicesRemote.findPacksByName(searchh);
		return "";
	}

	public String doUpdatePacks() {
		servicesRemote.updatePacks(p);
		init();
		p = new Packs();
		return "";
	}

	public String doFindPacksById(int id) {
		servicesRemote.findPacksById(id);
		return "";
	}

}
