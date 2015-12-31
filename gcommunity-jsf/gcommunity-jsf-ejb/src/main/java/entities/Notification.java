package entities;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Notifiacation
 *
 */
@Entity

public class Notification implements Serializable {

	
	private Integer idNotif;
	private String description;
	private int etat;
	private static final long serialVersionUID = 1L;
	
	private Message message;
	private ActiveMember activeMember;

	public Notification() {
		super();
	}   
	@Id    
	public Integer getIdNotif() {
		return this.idNotif;
	}

	public void setIdNotif(Integer idNotif) {
		this.idNotif = idNotif;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	@OneToOne
	@JoinColumn(name="message_fk")
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@ManyToOne
	public ActiveMember getActiveMember() {
		return activeMember;
	}
	public void setActiveMember(ActiveMember activeMember) {
		this.activeMember = activeMember;
	}
   
}
