package tn.esprit.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import services.interfaces.ActiveMemberServicesLocal;
import services.interfaces.VoteServicesLocal;
import entities.ActiveMember;
import entities.Vote;

@ManagedBean(name = "vote")
@ViewScoped
public class VoteBean {

	@EJB
	private ActiveMemberServicesLocal activeMemberServiceLocal;
	@EJB
	private VoteServicesLocal voteServicesLocal;

	@ManagedProperty("#{identityBean}")
	IdentityBean lBean;

	private Boolean avotecetteannee = false;
	List<ActiveMember> listeDesCandidats;
	List<Vote> listeDesVotes;

	@PostConstruct
	public void init() {
		listeDesCandidats = activeMemberServiceLocal.findAllActiveMember();
		listeDesVotes = voteServicesLocal.findAllVotes();

	

	

	}

	public VoteBean() {
	}

	public String DoVote(Integer a) {
		
//		for (Vote v : listeDesVotes) {
//			if (v.getActivemembervoted().getId()
//					.equals(lBean.getIdentifiedUser().getId())
//					&& (v.getYear().equals(new Date().getYear()))) {
//				avotecetteannee = true;
//
//			}
//		
//		}
		
		if(avotecetteannee ==false ){
		voteServicesLocal.addVote(new Date().getYear(), 6, 6);
		return"/Vote/home?faces-redirect=true";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(
	
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"NON AUTORISE", null

				));
			return null;
}
		

	}

	public Boolean getAvotecetteannee() {
		return avotecetteannee;
	}

	public void setAvotecetteannee(Boolean avotecetteannee) {
		this.avotecetteannee = avotecetteannee;
	}

	public List<ActiveMember> getListeDesCandidats() {
		return listeDesCandidats;
	}

	public void setListeDesCandidats(List<ActiveMember> listeDesCandidats) {
		this.listeDesCandidats = listeDesCandidats;
	}

	public IdentityBean getlBean() {
		return lBean;
	}

	public void setlBean(IdentityBean lBean) {
		this.lBean = lBean;
	}
}
