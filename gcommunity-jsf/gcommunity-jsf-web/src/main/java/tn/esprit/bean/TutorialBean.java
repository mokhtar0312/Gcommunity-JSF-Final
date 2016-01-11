package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.SimpleMember;
import entities.TutoLevel;
import entities.Tutorial;
import services.interfaces.TutorialServicesRemote;

@ManagedBean
@RequestScoped
public class TutorialBean {
	
	@EJB
	TutorialServicesRemote servicesRemote;
	
	private List<Tutorial> tutorials;
	private Tutorial m=new Tutorial();
	private SimpleMember s;
	
	
	private boolean showForm = false;
	private Boolean dispTable = false;
	private String name;
	private int id;
	private boolean edit;
	private String searchh;
	
	public TutoLevel[] getLevels() {
        return TutoLevel.values();
    }
	
	public List<Tutorial> getTutorials() {
		return tutorials;
	}
	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	public Tutorial getM() {
		return m;
	}
	public void setM(Tutorial m) {
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
	public SimpleMember getS() {
		return s;
	}
	
	@PostConstruct
	private void init() {
	tutorials =servicesRemote.findAllTutorial();
	}

	public void doDisplayTable() {
		dispTable = true;
	}
	
	public String doCreateTutorial() {
		
		
			
			servicesRemote.addTutorial(m, s);
		init();
		m=new Tutorial();
		dispTable = false;
		
		return "";
	}
public void edit(Tutorial item) {
		
		
	    this.m = item;
	    edit = true;
	}
	
	public String doDeleteTutorial() {
		servicesRemote.deleteTutorial(m);
		init();
		m=new Tutorial();
		return "";
	}
	
	public String doFindTutorialByTyped() {
		tutorials= servicesRemote.FindbyTyped(searchh);
		return "";
	}
	public String doUpdateTutorial(){
		servicesRemote.updateTutorial(m);
		init();
		m=new Tutorial();
		return "";
	}
	public String doFindTutorialdById(){
		servicesRemote.findTutorialById(id);
		return"";
	}
	
	
	

}
