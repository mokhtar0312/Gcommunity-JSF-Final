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
 * Entity implementation class for Entity: News
 *
 */
@Entity
public class News implements Serializable {

	private Integer id;
	private String Title;
	private Date date;
	private String description;
	private static final long serialVersionUID = 1L;


	private List<ActiveMember> ActiveMembers;


	public News() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

@ManyToMany(mappedBy="news")
	public List<ActiveMember> getActiveMembers() {
		return ActiveMembers;
	}

	public void setActiveMembers(List<ActiveMember> activeMembers) {
		ActiveMembers = activeMembers;
	}



}
