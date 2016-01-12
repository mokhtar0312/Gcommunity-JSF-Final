package tn.esprit.bean;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.interfaces.ActiveMemberServicesLocal;
import services.interfaces.SimpleMemberServicesLocal;
import services.interfaces.mailLocal;
import entities.ActiveMember;
import entities.SimpleMember;

@ManagedBean(name = "recover")
@ViewScoped
public class RecoverBean {

	@EJB
	private mailLocal mailservice;

	@EJB
	private ActiveMemberServicesLocal simpleMemberServicesLocal;
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	private String Email;

	public RecoverBean() {
	}

	public String doRecover() {
		ActiveMember found = null;
		List<ActiveMember> all = simpleMemberServicesLocal
				.findAllActiveMember();
		for (ActiveMember e : all) {
			if (e.getEmail().equals(Email))
				found = e;
		}

		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu
		// supprimes
		// les
		// lettres
		// dont
		// tu
		// ne
		// veux
		// pas
		String pass = "";
		for (int x = 0; x < 10; x++) {
			int i = (int) Math.floor(Math.random() * chars.length() - 1); // Si
			// tu
			// supprimes
			// des
			// lettres
			// tu
			// diminues
			// ce
			// nb
			pass += chars.charAt(i);
		}
		found.setPassword(pass);
		simpleMemberServicesLocal.updateActiveMember(found);
		try {
			mailservice.mail("Password Changing", "Here is your new password  "
					+ pass, Email);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "/index?faces-redirect=true";
	}

}
