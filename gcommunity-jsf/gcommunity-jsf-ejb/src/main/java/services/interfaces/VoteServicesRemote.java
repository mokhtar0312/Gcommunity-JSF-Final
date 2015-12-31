package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Vote;

@Remote
public interface VoteServicesRemote {

	Boolean addVote(Integer year, Integer idMembervoter,Integer idMembervoted);
	Vote findVoteById(Integer id);
	Boolean updateVote(Vote vote);
	Boolean deleteVote(Integer id);
	List<Vote> findAllVotes();
}
