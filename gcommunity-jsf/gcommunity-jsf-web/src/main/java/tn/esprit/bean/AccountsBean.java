package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import services.interfaces.ActiveMemberServicesLocal;
import entities.ActiveMember;

@ManagedBean(name = "accounts")
@ViewScoped
public class AccountsBean {

	@EJB
	private ActiveMemberServicesLocal activeMemberServicesLocal;

	private List<ActiveMember> activeMembers;

	public AccountsBean() {
	}

	@PostConstruct
	public void initModel() {
		setActiveMembers(activeMemberServicesLocal.findAllActiveMember());
	}

	public String doToggleStudentState(ActiveMember activeMember) {
		String navigateTo = null;
		if (activeMember.getApproved()) {
			activeMember.setApproved(false);
			;
		} else {
			activeMember.setApproved(true);
		}
		activeMemberServicesLocal.updateActiveMember(activeMember);
		setActiveMembers(activeMemberServicesLocal.findAllActiveMember());
		return navigateTo;
	}

	public String delete(ActiveMember activeMember) {
		String navigateTo = null;
		activeMemberServicesLocal.deleteActiveMember(activeMember);
		setActiveMembers(activeMemberServicesLocal.findAllActiveMember());
		return navigateTo;
	}

	public List<ActiveMember> getActiveMembers() {
		return activeMembers;
	}

	public void setActiveMembers(List<ActiveMember> activeMembers) {
		this.activeMembers = activeMembers;
	}

}
