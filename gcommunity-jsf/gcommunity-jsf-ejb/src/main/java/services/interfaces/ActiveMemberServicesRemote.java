package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.ActiveMember;

@Remote
public interface ActiveMemberServicesRemote {

	Boolean addActiveMember(ActiveMember activeMember);

	Boolean deleteActiveMemberById(Integer id);

	ActiveMember findActiveMemberById(Integer id);

	Boolean updateActiveMember(ActiveMember activeMember);

	Boolean deleteActiveMember(ActiveMember activeMember);

	List<ActiveMember> findAllActiveMember();
	ActiveMember findActiveMemberByUserName(String username);

}
