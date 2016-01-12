package tn.esprit.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import services.interfaces.SimpleMemberServicesLocal;
import entities.SimpleMember;

@ManagedBean(name = "register")
@ViewScoped
public class RegisterBean {

	@EJB
	private SimpleMemberServicesLocal simpleMemberServicesLocal;

	private SimpleMember MemberToRegister;

	@PostConstruct
	public void init() {
		MemberToRegister = new SimpleMember();
	}

	private String nam;

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPas() {
		return pas;
	}

	public void setPas(String pas) {
		this.pas = pas;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSumname() {
		return sumname;
	}

	public void setSumname(String sumname) {
		this.sumname = sumname;
	}

	public String getServ() {
		return serv;
	}

	public void setServ(String serv) {
		this.serv = serv;
	}

	private String surname;
	private String username;
	private String pas;
	private String mail;
	private String sumname;
	private String serv;

	public RegisterBean() {
	}

	public String DoRegister() {
		MemberToRegister.setName(nam);
		MemberToRegister.setSurname(surname);
		MemberToRegister.setUsername(username);
		MemberToRegister.setPassword(pas);
		MemberToRegister.setEmail(mail);
		MemberToRegister.setSummonerName(sumname);
		MemberToRegister.setServer(serv);
		MemberToRegister.setXp(50d);
		simpleMemberServicesLocal.addSimpleMember(MemberToRegister);
		return "/Login?faces-redirect=true";
	}

	public String doLogout() {
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.clear();
		navigateTo = "/index?faces-redirect=true";
		return navigateTo;
	}

	public SimpleMember getMemberToRegister() {
		return MemberToRegister;
	}

	public void setMemberToRegister(SimpleMember memberToRegister) {
		MemberToRegister = memberToRegister;
	}

}
