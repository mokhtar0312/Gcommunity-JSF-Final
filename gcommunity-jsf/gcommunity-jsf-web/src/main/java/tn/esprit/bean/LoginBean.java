package tn.esprit.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import services.interfaces.AuthentificationServiceLocal;
import services.interfaces.SimpleMemberServicesLocal;
import entities.ActiveMember;
import entities.SimpleMember;

@ManagedBean(name = "access")
@RequestScoped
public class LoginBean {

	@EJB
	private AuthentificationServiceLocal authentificationServiceLocal;
	private SimpleMemberServicesLocal simpleMemberServicesLocal;

	@ManagedProperty("#{identity}")
	private IdentityBean identityBean;
    private SimpleMember MemberToRegister;
	private String login;
	private String password;

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
	
	public String DoRegister(){
		
		simpleMemberServicesLocal.addSimpleMember(MemberToRegister);
		return "ok";}

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

	public SimpleMember getMemberToRegister() {
		return MemberToRegister;
	}

	public void setMemberToRegister(SimpleMember memberToRegister) {
		MemberToRegister = memberToRegister;
	}

}
