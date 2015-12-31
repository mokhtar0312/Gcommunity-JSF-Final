package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Membership;

@Local
public interface MembershipServicesLocal {
	Boolean addEvent(Membership membership);

	Boolean deleteMemberShipById(Integer id);

	Membership findMemberShipById(Integer id);

	Boolean updateMemberShip(Membership membership);

	Boolean deleteMemberShip(Membership membership);

	List<Membership> findAllMemberShips();
}
