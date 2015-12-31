package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Membership;

@Remote
public interface MembershipServicesRemote {
	Boolean addEvent(Membership membership);

	Boolean deleteMemberShipById(Integer id);

	Membership findMemberShipById(Integer id);

	Boolean updateMemberShip(Membership membership);

	Boolean deleteMemberShip(Membership membership);

	List<Membership> findAllMemberShips();
}
