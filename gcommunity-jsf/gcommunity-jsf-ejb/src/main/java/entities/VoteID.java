package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: VoteID
 *
 */
@Embeddable

public class VoteID implements Serializable {

	private Integer voter;
	private Integer voted;
	
	
	
	
	
	
	public VoteID(Integer voter, Integer voted) {
		super();
		this.voter = voter;
		this.voted = voted;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voted == null) ? 0 : voted.hashCode());
		result = prime * result + ((voter == null) ? 0 : voter.hashCode());
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
		VoteID other = (VoteID) obj;
		if (voted == null) {
			if (other.voted != null)
				return false;
		} else if (!voted.equals(other.voted))
			return false;
		if (voter == null) {
			if (other.voter != null)
				return false;
		} else if (!voter.equals(other.voter))
			return false;
		return true;
	}

	public Integer getVoter() {
		return voter;
	}

	public void setVoter(Integer voter) {
		this.voter = voter;
	}

	public Integer getVoted() {
		return voted;
	}

	public void setVoted(Integer voted) {
		this.voted = voted;
	}

	private static final long serialVersionUID = 1L;

	public VoteID() {
		super();
	}
   
}
