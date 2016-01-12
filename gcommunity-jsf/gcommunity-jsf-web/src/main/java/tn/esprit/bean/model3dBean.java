package tn.esprit.bean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.Event;
import entities.Model3D;
import services.interfaces.Model3DServicesRemote;

@ManagedBean
@RequestScoped
public class model3dBean {
	@EJB
	Model3DServicesRemote servicesRemote;

	private List<Model3D> models;
	private Model3D m=new Model3D();
	private boolean showForm = false;
	private Boolean dispTable = false;
	private String name;
	private int id;
	private String img;
	private boolean edit;
	private String searchh;
	public List<Model3D> getModels() {
		return models;
	}
	public void setModels(List<Model3D> models) {
		this.models = models;
	}
	public Model3D getM() {
		return m;
	}
	public void setM(Model3D m) {
		this.m = m;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	models =servicesRemote.finAll3DModels();
	}

	public void doDisplayTable() {
		dispTable = true;
	}
	
	public String doCreateModel() {
		
		servicesRemote.addM(m);
		init();
		m=new Model3D();
		dispTable = false;
		
		return "";
	}
	
	
	public void edit(Model3D item) {
		
		
	    this.m = item;
	    edit = true;
	}
	
	public String doDeleteModel() {
		servicesRemote.deleteModel3D(id);
		init();
		m=new Model3D();
		return "";
	}

	
	public String doUpdateModel(){
		servicesRemote.updateModel3D(m);
		init();
		m=new Model3D();
		return "";
	}
	public String doFindmodeldById(){
		servicesRemote.findModel3DById(id);
		return"";
	}
}
