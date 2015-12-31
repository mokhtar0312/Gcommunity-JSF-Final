package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Model3D
 *
 */
@Entity

public class Model3D implements Serializable {

	
	private Integer id;
	private Date datePost;
	private String name;
	private String img;
	private static final long serialVersionUID = 1L;
	
	private List<SimpleMember> simpleMembers;


	public Model3D() {
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
	public Date getDatePost() {
		return this.datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	@ManyToMany(mappedBy="model3Ds")
	public List<SimpleMember> getSimpleMembers() {
		return simpleMembers;
	}
	public void setSimpleMembers(List<SimpleMember> simpleMembers) {
		this.simpleMembers = simpleMembers;
	}
	
   
}
