package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: simpleMember
 *
 */
@Entity(name = "simpleMember")
public class SimpleMember implements Serializable {

	private Integer id;
	private String name;
	private String surname;
	private String username;
	private String password;
	private String summonerName;
	private String server;
	private Double xp;
	private String email;
	private static final long serialVersionUID = 1L;

	private List<Streams> streamss;
	private List<Tutorial> tutorials;
	private List<Event> events;
	private List<Model3D> model3Ds;
	private List<Packs> packss;

	public SimpleMember() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSummonerName() {
		return this.summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public Double getXp() {
		return this.xp;
	}

	public void setXp(Double xp) {
		this.xp = xp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@ManyToMany
	public List<Model3D> getModel3Ds() {
		return model3Ds;
	}

	public void setModel3Ds(List<Model3D> model3Ds) {
		this.model3Ds = model3Ds;
	}

	@OneToMany(mappedBy = "simplemember")
	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}

	@ManyToMany
	public List<Packs> getPackss() {
		return packss;
	}

	public void setPackss(List<Packs> packss) {
		this.packss = packss;
	}

	@ManyToMany
	public List<Streams> getStreamss() {
		return streamss;
	}

	public void setStreamss(List<Streams> streamss) {
		this.streamss = streamss;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((model3Ds == null) ? 0 : model3Ds.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((packss == null) ? 0 : packss.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		result = prime * result
				+ ((streamss == null) ? 0 : streamss.hashCode());
		result = prime * result
				+ ((summonerName == null) ? 0 : summonerName.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result
				+ ((tutorials == null) ? 0 : tutorials.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((xp == null) ? 0 : xp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleMember other = (SimpleMember) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model3Ds == null) {
			if (other.model3Ds != null)
				return false;
		} else if (!model3Ds.equals(other.model3Ds))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (packss == null) {
			if (other.packss != null)
				return false;
		} else if (!packss.equals(other.packss))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		if (streamss == null) {
			if (other.streamss != null)
				return false;
		} else if (!streamss.equals(other.streamss))
			return false;
		if (summonerName == null) {
			if (other.summonerName != null)
				return false;
		} else if (!summonerName.equals(other.summonerName))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (tutorials == null) {
			if (other.tutorials != null)
				return false;
		} else if (!tutorials.equals(other.tutorials))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (xp == null) {
			if (other.xp != null)
				return false;
		} else if (!xp.equals(other.xp))
			return false;
		return true;
	}

}
