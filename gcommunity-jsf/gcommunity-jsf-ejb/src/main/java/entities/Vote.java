package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Vote
 *
 */
@Entity
public class Vote implements Serializable {

	private VoteID voteid;
	private ActiveMember activemembervoter;
	private ActiveMember activemembervoted;
	private Integer year;

	
	

	
	
	
	
	public Vote(ActiveMember activemembervoter, ActiveMember activemembervoted,
			Integer year) {
		this.voteid = new VoteID(activemembervoter.getId(), activemembervoted.getId());
		this.activemembervoter = activemembervoter;
		this.activemembervoted = activemembervoted;
		this.year = year;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "voter", referencedColumnName = "id", updatable = false, insertable = false)
	public ActiveMember getActivemembervoter() {
		return activemembervoter;
	}

	public void setActivemembervoter(ActiveMember activemembervoter) {
		this.activemembervoter = activemembervoter;
	}

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "voted", referencedColumnName = "id", updatable = false, insertable = false)
	public ActiveMember getActivemembervoted() {
		return activemembervoted;
	}

	public void setActivemembervoted(ActiveMember activemembervoted) {
		this.activemembervoted = activemembervoted;
	}

	@EmbeddedId
	public VoteID getVoteid() {
		return voteid;
	}

	public void setVoteid(VoteID voteid) {
		this.voteid = voteid;
	}

	
	private static final long serialVersionUID = 1L;

	public Vote() {
		super();
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
