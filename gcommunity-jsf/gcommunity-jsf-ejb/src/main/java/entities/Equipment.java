package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Equipment
 *
 */
@Entity

public class Equipment implements Serializable {

	
	private Integer Id;
	private String reference;
	private String name;
	private Boolean state;
	private static final long serialVersionUID = 1L;
	
	private List<ActiveMember> ActiveMembers;


	public Equipment() {
		super();
	}   
	
	public Equipment(String reference, String name, Boolean state) {
		super();
		this.reference = reference;
		this.name = name;
		this.state = state;
	}

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	@ManyToMany(mappedBy="equipments")
	public List<ActiveMember> getActiveMembers() {
		return ActiveMembers;
	}
	public void setActiveMembers(List<ActiveMember> activeMembers) {
		ActiveMembers = activeMembers;
	}
	
   
}
