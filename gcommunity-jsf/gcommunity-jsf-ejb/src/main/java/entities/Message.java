package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	
	private Integer idMessage;
	private String content;
	private String subject;
	private Date date;
	private int idto;
	
	private ActiveMember activeMember;
	private Notification notifiacation;
	private static final long serialVersionUID = 1L;

	public Message() {
		super();
	}   
	@Id   
	@GeneratedValue
	public Integer getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne
	public ActiveMember getActiveMember() {
		return activeMember;
	}
	public void setActiveMember(ActiveMember activeMember) {
		this.activeMember = activeMember;
	}
	@OneToOne(mappedBy="message")

	public Notification getNotifiacation() {
		return notifiacation;
	}
	public void setNotifiacation(Notification notifiacation) {
		this.notifiacation = notifiacation;
	}
	public int getIdto() {
		return idto;
	}
	public void setIdto(int idto) {
		this.idto = idto;
	}
   
}
