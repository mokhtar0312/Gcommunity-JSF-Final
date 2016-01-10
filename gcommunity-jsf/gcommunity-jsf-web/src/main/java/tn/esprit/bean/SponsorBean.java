package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;








import entities.Sponsor;
import services.interfaces.SponsorServicesRemote;


@ManagedBean
@RequestScoped
public class SponsorBean {
	@EJB
	SponsorServicesRemote servicesRemote;

private List<Sponsor> sponsors;

private Sponsor m=new Sponsor();
private boolean showForm = false;
private Boolean dispTable = false;
private String name;
private int id;
private boolean edit;
private String searchh;
public List<Sponsor> getSponsors() {
	return sponsors;
}
public void setSponsors(List<Sponsor> sponsors) {
	this.sponsors = sponsors;
}
public Sponsor getM() {
	return m;
}
public void setM(Sponsor m) {
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

@PostConstruct
private void init() {
sponsors =servicesRemote.findAllSponsors();
}

public void doDisplayTable() {
	dispTable = true;
}


public String doCreateSponsor() {
	
	
		
		servicesRemote.addSponsor(m);
	init();
	m=new Sponsor();
	dispTable = false;
	
	return "";
}

public void edit(Sponsor item) {
	
	
    this.m = item;
    edit = true;
}

public String doDeleteSponsor() {
	servicesRemote.deleteSponsor(m);
	init();
	m=new Sponsor();
	return "";
}
//public String doFindAgencyByName() {
//	m=model3dServicesRemote.findModel3DById(m.getId());
//	return "";
//}
public String doUpdateSponsor(){
	servicesRemote.updateSponsor(m);
	init();
	m=new Sponsor();
	dispTable = false;
	
	return "";

}
@SuppressWarnings("unchecked")
public String doFindSponsordById(){
	m= servicesRemote.findSponsorById(id);
	sponsors.add(m);
	System.out.println(m.getDescription());
	return"";
}
	

}
