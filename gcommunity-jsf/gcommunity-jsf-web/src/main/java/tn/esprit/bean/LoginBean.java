package tn.esprit.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import services.interfaces.AuthentificationServiceLocal;

import entities.ActiveMember;
import entities.SimpleMember;

@ManagedBean(name = "access")
@ViewScoped
public class LoginBean {

	@EJB
	private AuthentificationServiceLocal authentificationServiceLocal;



	@ManagedProperty("#{identity}")
	private IdentityBean identityBean;

	private Boolean loggedIn;
	private String login;
	private String password;
	private String Email;

	@PostConstruct
	public void init() {

	}

	public LoginBean() {
	}

	

	public String doLogin() {
		String navigateTo = null;
		SimpleMember found = authentificationServiceLocal.authentifier(login,
				password);

		if (found != null) {
			identityBean.setIdentifiedUser(found);
			if (found instanceof ActiveMember) {
				navigateTo = "/index?faces-redirect=true";
			} else if (found instanceof SimpleMember) {
				navigateTo = "/index?faces-redirect=true";
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"NON AUTORISE", null

					));

		}
		return navigateTo;
	}

	public String doLogout() {
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.clear();
		
		navigateTo = "/index?faces-redirect=true";
		return navigateTo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
