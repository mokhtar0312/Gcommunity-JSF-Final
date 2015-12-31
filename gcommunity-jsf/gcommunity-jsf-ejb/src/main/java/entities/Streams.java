package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Streams
 *
 */
@Entity
public class Streams implements Serializable {

	private Integer id;
	private Date date_diffusion;
	private String winner;
	private Integer viewers;
	private String url;
	private static final long serialVersionUID = 1L;

	private List<SimpleMember> simpleMembers;

	private List<ActiveMember> ActiveMembers;

	public Streams() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate_diffusion() {
		return this.date_diffusion;
	}

	public void setDate_diffusion(Date date_diffusion) {
		this.date_diffusion = date_diffusion;
	}

	public String getWinner() {
		return this.winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Integer getViewers() {
		return this.viewers;
	}

	public void setViewers(Integer viewers) {
		this.viewers = viewers;
	}
@ManyToMany(mappedBy="streamsss")
	public List<ActiveMember> getActiveMembers() {
		return ActiveMembers;
	}

	public void setActiveMembers(List<ActiveMember> activeMembers) {
		ActiveMembers = activeMembers;
	}
@ManyToMany(mappedBy="streamss")
	public List<SimpleMember> getSimpleMembers() {
		return simpleMembers;
	}

	public void setSimpleMembers(List<SimpleMember> simpleMembers) {
		this.simpleMembers = simpleMembers;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

}
