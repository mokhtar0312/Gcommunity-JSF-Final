package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Tutorial
 *
 */
@Entity
public class Tutorial implements Serializable {

	private Integer id;
	private String name;
	private String description;
	private TutoLevel tutolev;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TutoLevel getTutolev() {
		return tutolev;
	}

	public void setTutolev(TutoLevel tutolev) {
		this.tutolev = tutolev;
	}

	private static final long serialVersionUID = 1L;

	private SimpleMember simplemember;

	@ManyToOne
	public SimpleMember getSimplemember() {
		return simplemember;
	}

	public void setSimplemember(SimpleMember simplemember) {
		this.simplemember = simplemember;
	}

	public Tutorial() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
