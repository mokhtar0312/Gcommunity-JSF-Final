package tn.esprit.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.ActiveMember;
import entities.SimpleMember;


@ManagedBean(name = "identity")
@SessionScoped
public class IdentityBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6855249801392965207L;

	public SimpleMember getIdentifiedUser() {
		return identifiedUser;
	}



	public void setIdentifiedUser(SimpleMember identifiedUser) {
		this.identifiedUser = identifiedUser;
	}



	private SimpleMember identifiedUser;

	public IdentityBean() {
	}

	

	public Boolean hasRole(String role) {
		Boolean response = false;
		switch (role) {
		case "Admin":
			response = identifiedUser instanceof ActiveMember;
			break;
		case "Client":
			response = identifiedUser instanceof SimpleMember;
			break;
		}
		return response;
	}

}
