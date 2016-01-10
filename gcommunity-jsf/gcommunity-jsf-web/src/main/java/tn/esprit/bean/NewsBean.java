package tn.esprit.bean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import entities.News;
import services.interfaces.NewsServicesRemote;
@ManagedBean
@RequestScoped
public class NewsBean {
@EJB
NewsServicesRemote NewsServicesRemote;
private List<News> Newss;
private News m=new News();
private boolean showForm = false;
private Boolean dispTable = false;
private String name;
private int id;
private boolean edit;
private String searchh;
public List<News> getNewss() {
	return Newss;
}
public void setNewss(List<News> Newss) {
	this.Newss = Newss;
}
public News getM() {
	return m;
}
public void setM(News m) {
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
	Newss =NewsServicesRemote.DisplayAllNews();
}
public void doDisplayTable() {
	dispTable = true;
}
public String doCreateNews() {
	
	
		
		NewsServicesRemote.addNews(m);
	init();
	m=new News();
	dispTable = false;
	
	return "";
}
public void edit(News item) {
	
	
    this.m = item;
    edit = true;
}
public String doDeleteNews() {
	NewsServicesRemote.deleteNews(m);
	init();
	m=new News();
	return "";
}
//public String doFindAgencyByName() {
//	m=NewsServicesRemote.findNewsById(m.getId());
//	return "";
//}
public String doUpdateNews(){
	NewsServicesRemote.updateNews(m);
	init();
	m=new News();
	dispTable = false;
	
	return "";
}
public String doFindNewsById(){
	Newss = NewsServicesRemote.FindbyTyped(searchh);
	
	
	return"";
}
	
	
	
	
}