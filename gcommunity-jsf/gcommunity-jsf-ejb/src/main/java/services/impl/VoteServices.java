package services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.ActiveMemberServicesLocal;
import services.interfaces.VoteServicesLocal;
import services.interfaces.VoteServicesRemote;
import entities.ActiveMember;
import entities.Vote;

/**
 * Session Bean implementation class VoteServices
 */
@Stateless
@LocalBean
public class VoteServices implements VoteServicesRemote, VoteServicesLocal {
	@PersistenceContext
	EntityManager entitymanager;
	@EJB
	private ActiveMemberServicesLocal activeMemberServices;

	/**
	 * Default constructor.
	 */
	public VoteServices() {

	}

	@Override
	public Boolean addVote(Integer year, Integer idMembervoter,Integer idMembervoted) {
		boolean b = false;
		try {
			ActiveMember memberVoter= activeMemberServices
					.findActiveMemberById(idMembervoter);
			ActiveMember memberVoted= activeMemberServices
					.findActiveMemberById(idMembervoted);
			Vote vote=new Vote(memberVoter, memberVoted, year);
			entitymanager.merge(vote);
			b = true;

		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public Vote findVoteById(Integer id) {
		return entitymanager.find(Vote.class, id);

	}

	@Override
	public Boolean updateVote(Vote vote) {
		boolean b = false;
		try {
			entitymanager.merge(vote);
			b = true;

		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean deleteVote(Integer id) {
		boolean b = false;
		try {
			entitymanager.remove(findVoteById(id));

		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	
	@Override
	public List<Vote> findAllVotes() {

		String jpql = "select v from Vote v";
		Query query = entitymanager.createQuery(jpql);

		return query.getResultList();
	}
	
	

}
