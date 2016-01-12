package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.Event;

import services.interfaces.EventServicesRemote;

@ManagedBean
@RequestScoped
public class EventBean {

	@EJB
	EventServicesRemote servicesRemote;
	
	private List<Event> events;
	private Event m=new Event();
	private boolean showForm = false;
	private Boolean dispTable = false;
	private String name;
	private int id;
	private boolean edit;
	private String searchh;
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public Event getM() {
		return m;
	}
	public void setM(Event m) {
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
	events =servicesRemote.findAllEvents();
	}

	public void doDisplayTable() {
		dispTable = true;
	}
	
	public String doCreateEvent() {
		
		
			
			servicesRemote.addEvent(m);
		init();
		m=new Event();
		dispTable = false;
		
		return "";
	}
	
	
	public void edit(Event item) {
		
		
	    this.m = item;
	    edit = true;
	}
	
	public String doDeleteEvent() {
		servicesRemote.deleteEvent(m);
		init();
		m=new Event();
		return "";
	}
	public String doFindEventByName() {
		events=(List<Event>) servicesRemote.FindbyTyped(searchh);
		return "";
	}
	public String doUpdateEvent(){
		servicesRemote.updateEvent(m);
		init();
		m=new Event();
		return "";
	}
	public String doFindEventdById(){
		servicesRemote.findEventById(id);
		return"";
	}

}
