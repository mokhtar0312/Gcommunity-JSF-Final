package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sponsor
 *
 */
@Entity

public class Sponsor implements Serializable {

	   
	
	private Integer id;
	private String contribution;
	private String description;
	private String level;
	private static final long serialVersionUID = 1L;
	
	private List<ActiveMember> ActiveMembers;


	public Sponsor() {
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
	public String getContribution() {
		return this.contribution;
	}

	public void setContribution(String contribution) {
		this.contribution = contribution;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	@ManyToMany(mappedBy="sponsors")
	public List<ActiveMember> getActiveMembers() {
		return ActiveMembers;
	}
	public void setActiveMembers(List<ActiveMember> activeMembers) {
		ActiveMembers = activeMembers;
	}
	
   
}
