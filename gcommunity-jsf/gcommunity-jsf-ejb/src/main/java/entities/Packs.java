package entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Packs
 *
 */
@Entity

public class Packs implements Serializable {

	
	private Integer id;
	private String name;
	private Float price;
	private Integer quantity;
	private String category;
	private Date datemiseenligne;
	private static final long serialVersionUID = 1L;
	
	private List<SimpleMember> simpleMembers;
	

	public Packs() {
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
	
	public Date getDatemiseenligne() {
		return datemiseenligne;
	}
	public void setDatemiseenligne(Date datemiseenligne) {
		this.datemiseenligne = datemiseenligne;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}   
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	@ManyToMany(mappedBy="packss")
	public List<SimpleMember> getSimpleMembers() {
		return simpleMembers;
	}
	public void setSimpleMembers(List<SimpleMember> simpleMembers) {
		this.simpleMembers = simpleMembers;
	}
	
   
}
